import java.util.*;

public class CourseGradebook extends Gradebook {
   // Protected fields for storing gradebook data
   protected HashMap<String, HashMap<Integer, Double>> assignmentScores = new HashMap<>();

   @Override
   public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
       // Retrieve scores for the specified assignment, or return an empty map if not found
       return assignmentScores.getOrDefault(assignmentName, new HashMap<>());
   }

   @Override
   public double getScore(String assignmentName, Integer studentID) {
       // Retrieve the scores for the assignment
       HashMap<Integer, Double> scores = assignmentScores.get(assignmentName);
       if (scores != null) {
           // Return the student's score if it exists, otherwise return NaN
           return scores.getOrDefault(studentID, Double.NaN);
       }
       return Double.NaN;
   }

   @Override
   public ArrayList<String> getSortedAssignmentNames() {
       // Get all distinct assignment names and sort them
       ArrayList<String> assignments = new ArrayList<>(assignmentScores.keySet());
       Collections.sort(assignments);
       return assignments;
   }

   @Override
   public ArrayList<Integer> getSortedStudentIDs() {
       // Collect all distinct student IDs
       HashSet<Integer> studentIDs = new HashSet<>();
       for (HashMap<Integer, Double> scores : assignmentScores.values()) {
           studentIDs.addAll(scores.keySet());
       }
       // Sort the student IDs
       ArrayList<Integer> sortedStudentIDs = new ArrayList<>(studentIDs);
       Collections.sort(sortedStudentIDs);
       return sortedStudentIDs;
   }

   @Override
   public HashMap<String, Double> getStudentScores(Integer studentID) {
       // Map assignments to the student's scores
       HashMap<String, Double> studentScores = new HashMap<>();
       for (Map.Entry<String, HashMap<Integer, Double>> entry : assignmentScores.entrySet()) {
           String assignmentName = entry.getKey();
           HashMap<Integer, Double> scores = entry.getValue();
           if (scores.containsKey(studentID)) {
               studentScores.put(assignmentName, scores.get(studentID));
           }
       }
       return studentScores;
   }

   @Override
   public void setScore(String assignmentName, Integer studentID, Double score) {
       // Retrieve or create the scores map for the assignment
       assignmentScores.computeIfAbsent(assignmentName, k -> new HashMap<>()).put(studentID, score);
   }
}

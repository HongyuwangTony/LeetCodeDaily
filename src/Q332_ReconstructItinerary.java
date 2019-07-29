import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Q332_ReconstructItinerary {
    static class Solution {
        private HashMap<String, PriorityQueue<String>> airlines = new HashMap<>();

        private void reconstruct(String departure, List<String> itinerary) {
            PriorityQueue<String> airline = airlines.get(departure);
            while (airline != null && !airline.isEmpty()) {
                reconstruct(airline.poll(), itinerary);
            }
            itinerary.add(0, departure);
        }

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String departure = ticket.get(0), arrival = ticket.get(1);
                if (!airlines.containsKey(departure)) airlines.put(departure, new PriorityQueue<>());
                airlines.get(departure).add(arrival);
            }
            List<String> itinerary = new ArrayList<>();
            reconstruct("JFK", itinerary);
            return itinerary;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findItinerary(
                List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"))
        ));
        System.out.println(new Solution().findItinerary(
                List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"), List.of("ATL", "JFK"),
                        List.of("ATL", "SFO"))
        ));
        System.out.println(new Solution().findItinerary(
                List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK"))
        ));
    }
}

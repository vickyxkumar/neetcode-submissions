class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> pair = new ArrayList<>();
        for(int i = 0; i< position.length; i++){
            pair.add(new int[]{position[i], speed[i]});
        }

        Collections.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> carFleet = new Stack<>();

        for(int i = 0; i< pair.size(); i++){
            carFleet.add(((target-pair.get(i)[0]) * 1.0)/pair.get(i)[1]);
            if(carFleet.size() >= 2){
                double top = carFleet.pop();
                if(carFleet.peek() < top){
                   carFleet.add(top);
                }
            }
        }

        return carFleet.size();
    }
}

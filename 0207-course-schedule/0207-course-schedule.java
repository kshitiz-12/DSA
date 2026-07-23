class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList<>();

        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }

        int[] state = new int[numCourses];

        for(int i=0;i<numCourses;i++){

            if(!dfs(graph,state,i))
                return false;
        }

        return true;
    }

    public boolean dfs(ArrayList<Integer>[] graph,int[] state,int course){

        if(state[course]==1)
            return false;

        if(state[course]==2)
            return true;

        state[course]=1;

        for(int next : graph[course]){

            if(!dfs(graph,state,next))
                return false;
        }

        state[course]=2;

        return true;
    }
}
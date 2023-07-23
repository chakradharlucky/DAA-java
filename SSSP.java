class SSSP
{
   void sssp(int graph[][],int source)
   {
    int gl=graph.length,dis[] = new int[gl];
    for(int i=0;i<gl;i++)
        {
            dis[i]=graph[source][i];//finding distance from source to all vertices in the graph
        }
    for(int k=0;k<gl;k++)
    {
        for(int i=0;i<gl;i++)
        {
            if((dis[i])>(dis[k]+graph[k][i]))
            {
                dis[i]=dis[k]+graph[k][i];
            }
        }
    }
    System.out.println("Distances from: ");
    for(int i=0;i<gl;i++)
    {
        if(dis[i]==9999){
            System.out.println((source+1)+" to "+(i+1)+" "+"INF");
        }
        else{
            System.out.println((source+1)+" to "+(i+1)+" "+dis[i]);
        }
        
    }
   }
    public static void main(String[] args) {
        int inf = 9999;//Infinity distance between non adjecent vertices
        int graph[][] = {{0,50,45,10,inf,inf},
                        {inf,0,10,15,inf,inf},
                        {inf,inf,0,inf,30,inf},
                        {20,inf,inf,0,15,inf},
                        {inf,20,35,inf,0,inf},
                        {inf,inf,inf,inf,3,0}};
        SSSP obj = new SSSP();
        obj.sssp(graph,0);
    }
}

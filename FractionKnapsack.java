import java.util.Scanner;

public class FractionKnapsack {
    public static void main(String[] args) {
    
	    int m = 15,n = 7,profit[] = {5,10,15,7,8,9,4},weight[] = {1,3,5,4,1,3,2},intTemp;
        float p_by_w[] = new float[n],total_profit=0f,temp;

        for(int i=0;i<n;i++)// Finding profit by weight and storing into the p_by_w array
			p_by_w[i]=((float)profit[i]/(float)weight[i]);

            for(int i=0;i<n;i++){//you can use i<p_by_w.lenght
		   	 for(int j=i+1;j<n;j++)// you can use i<p_by_w.lenght
		   	 {
			   	if(p_by_w[i]<p_by_w[j]) //Sorting Profit by weight array in decending order and profit,weight arrays 
			  	 {
			     	temp = p_by_w[i];
			     	p_by_w[i]=p_by_w[j];
			      	p_by_w[j]=temp;

			     	intTemp = profit[i];
                    profit[i]= profit[j];
			      	profit[j]=intTemp;
			      	
                    intTemp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = intTemp;
			 	 }
		    	}
            }
       		 for(int i=0;((m>0)&&(i<n));i++)//Placing objects into knapsack 
        		{
            		if(m>=weight[i])//is it possiable to place complete object into knapsack? 
           			{
                		total_profit+=profit[i];
                		m-=weight[i];
            		}
            		else
           			{
                		total_profit+=((float)m/(float)weight[i])*(float)profit[i];
               			 m=0;
                    }
        		}
    System.out.println("\nTotal Profit(P/W) = "+total_profit);
    }   
}
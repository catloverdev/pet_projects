package lab5;
import mpi.*;
import java.util.Arrays;
public class Lab5 {

    public static void main(String[] args) {
        // TODO code application logic here
                MPI.Init(args);
        int TAG = 0; 
        int rank = MPI.COMM_WORLD.Rank(); 
        int size = MPI.COMM_WORLD.Size();
        int N = 100; 
        //по кольцу
        int prev; int next;
        prev = rank -1; next = rank + 1;
        if(rank == 0) prev = size - 1; 
        if(rank == size - 1) next = 0; 
        
        int a[][] = new int[N][N];
        int b[] = new int[N];
        int c[]= new int[N];
        long startTime = System.currentTimeMillis();
        if(size >= 5){ 
            if(rank==0) //нулевой процесс отправляет остальным матрицу равными частями и ждёт, пока они пришлют рез-т
            {
                Request[] request = new Request[size-1]; //(size-1)
                int[] main_arr = new int[N];
                int v = N/size;
                for (int i = 0;i < size-1; i++)
                    for (int j = 0;j<v;j++)
                    MPI.COMM_WORLD.Send(a[i], 0, v-1, MPI.INT, i, i);
                MPI.COMM_WORLD.Recv(a[0], 0, 19, MPI.INT, 0, 0);
                
                MPI.COMM_WORLD.Send(c[0], 0, 19, MPI.INT, 0, 0);
                for (int j = 0;j < size-1; j++)
                    MPI.COMM_WORLD.Recv(c[j*v-1], 0, 19, MPI.INT, j, j);
                Arrays.sort(main_arr); 
                System.out.println("Woah! "+"vector"+Arrays.toString(c)+" from proc 0"); 
            }
            else
            {
                if(rank<3)
                {
                    int guess; 
                    if(rank == 2) guess = left; 
                    else guess = right; 
                    Request[] request = new Request[guess]; 
                    int[] mas = new int[guess]; 
                    if (rank==2){
                        for(int i = 0;i < guess; i++){ 
                            request[i] = MPI.COMM_WORLD.Irecv(mas, i, 1,MPI.INT, i + 3 + (left-1-i), TAG); 
                        } 
                    }
                    if (rank==1){
                        for(int i = 0;i < guess; i++){ 
                            request[i] = MPI.COMM_WORLD.Irecv(mas, i, 1,MPI.INT, size-1-i, TAG); 
                        } 
                    }
                    //for(int i = 0;i < guess; i++){ 
                    //    request[i] = MPI.COMM_WORLD.Irecv(mas, i, 1,MPI.INT, i + 3 + (left*(2 - rank)), TAG); 
                    //} 
                    Request.Waitall(request); 
                    Arrays.sort(mas); 
                    MPI.COMM_WORLD.Isend(mas, 0, mas.length, MPI.INT, 0, TAG); 
                    System.out.println(rank+" proc is here! It's my arrr: "+Arrays.toString(mas)); 
                }
                else
                {
                    int[] s = {rank}; 
                    if(rank < size - right){ 
                        MPI.COMM_WORLD.Isend(s, 0, 1, MPI.INT, 2, TAG); 
                        System.out.println("Proc "+rank+" send message to proc 2"); 
                    } 
                    else { 
                        MPI.COMM_WORLD.Isend(s, 0, 1, MPI.INT, 1, TAG); 
                        System.out.println("Proc "+rank+" send message to proc 1"); 
                    } 
                }
              }
            long endTime = System.currentTimeMillis();
            System.out.println("Calculated in " +
                                             (endTime - startTime) + " milliseconds");
        }
        MPI.Finalize();
    }
}

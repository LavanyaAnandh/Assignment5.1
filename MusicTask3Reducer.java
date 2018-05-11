import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MusicTask3Reducer
  extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
  
  @Override
  
  public void reduce(IntWritable key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
      System.out.println("TrackId=>"+key) ;	
    
      int SharedStatus = 0;
      int sum = 0;
      for (IntWritable value : values) {
    	  SharedStatus=value.get();	
    	  sum++;
       }		
       context.write(key, new IntWritable(sum)); //This will write the final output as (TrackId, SharedStatus)
  }
}


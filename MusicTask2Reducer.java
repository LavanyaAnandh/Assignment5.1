import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MusicTask2Reducer
  extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
  
  @Override
  
  public void reduce(IntWritable key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
      System.out.println("TrackId=>"+key) ;	//For Logging purpose.
    
      int heardStatus = 0;
      for (IntWritable value : values) {
    	  heardStatus=value.get();	
       }		
       context.write(key, new IntWritable(heardStatus)); //This will write the final output as (TrackId, heardStatus)
  }
}

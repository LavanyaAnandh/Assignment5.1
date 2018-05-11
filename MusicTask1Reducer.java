import java.io.IOException;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MusicTask1Reducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>
{
	@Override
	public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) 
			throws IOException, InterruptedException
	{
		IntWritable TrackId = new IntWritable(); 
		System.out.println("Text Key    =>"+key.toString());
		int sum = 0;
	    for (IntWritable value : values) {
	    	sum++;
	    	TrackId = value;  //This will store the trackId value
	    }
	    if (sum<=1)
	      context.write(key,TrackId); //This will write the final output as (userId, TrackId)
		    
	}
}
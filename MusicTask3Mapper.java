import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.*;


public class MusicTask3Mapper
  extends Mapper<LongWritable, Text, IntWritable, IntWritable> 
{
	 IntWritable t1 = new IntWritable();
	 IntWritable t2 = new IntWritable();;
	 
	 public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException 
	{   
		String[] lineArray = value.toString().split("\\|"); //This will get the entire line as array of words by splitting the delimiter '|'
		if(Integer.parseInt(lineArray[2])==1)
		{
			t1.set(Integer.parseInt(lineArray[1])); //This will parse the string value into integer and sets the value in t1
			t2.set(Integer.parseInt(lineArray[2])); //This will parse the string value into integer and sets the value in t2
			context.write(t1, t2); //This will write the 1st and 2nd  element in string of array as (trackId, shared status)
		}
	}
}
	
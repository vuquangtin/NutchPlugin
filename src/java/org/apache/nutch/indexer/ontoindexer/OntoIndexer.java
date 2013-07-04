package java.org.apache.nutch.indexer.ontoindexer;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.nutch.crawl.CrawlDatum;
import org.apache.nutch.crawl.Inlinks;
import org.apache.nutch.indexer.IndexingException;
import org.apache.nutch.indexer.IndexingFilter;
import org.apache.nutch.indexer.NutchDocument;
import org.apache.nutch.parse.Parse;
import org.apache.nutch.parse.ParseResult;
import org.apache.nutch.parse.Parser;
import org.apache.nutch.protocol.Content;

public class OntoIndexer implements IndexingFilter{

	private Configuration conf;

	@Override
	public Configuration getConf() {
		return this.conf;
	}

	@Override
	public void setConf(Configuration arg0) {
		this.conf = arg0;

	}

		@Override
		public NutchDocument filter(NutchDocument doc, Parse parse, Text url,
				CrawlDatum datum, Inlinks inlinks) throws IndexingException {
			//Il metodo che fa al caso nostro
	
			try{
				// Create file 
				FileWriter fstream = new FileWriter("/home/hduser/out.txt");
				BufferedWriter out = new BufferedWriter(fstream);
	
				out.write(url.toString()+"\n");
				//Close the output stream
				out.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
	
			return doc;
		}
}



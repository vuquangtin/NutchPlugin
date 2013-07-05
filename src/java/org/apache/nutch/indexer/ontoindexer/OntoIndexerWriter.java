package org.apache.nutch.indexer.ontoindexer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.nutch.crawl.CrawlDatum;
import org.apache.nutch.crawl.Inlinks;
import org.apache.nutch.indexer.IndexWriter;
import org.apache.nutch.indexer.IndexingException;
import org.apache.nutch.indexer.IndexingFilter;
import org.apache.nutch.indexer.NutchDocument;
import org.apache.nutch.parse.Parse;

public class OntoIndexerWriter implements IndexWriter{
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
	public void open(JobConf job, String name) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(NutchDocument doc) throws IOException {
		System.out.println("Salve, sono OntoIndexer");
		
	}

	@Override
	public void delete(String key) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(NutchDocument doc) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
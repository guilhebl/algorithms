package com.guilhebl.algo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://careercup.com/question?id=6002346992599040
 *
 */
public class ShardKeyRange {
	
	public static void main(String[] args) {
		List<Shard> shards = new ArrayList<>();
		List<Key> keys = new ArrayList<>();
		
		shards.add(new Shard(1,9));
		shards.add(new Shard(12,59));
		shards.add(new Shard(100,999));
		shards.add(new Shard(1000,1999));
		
		keys.add(new Key(2,3));
		keys.add(new Key(6,8));
		keys.add(new Key(11,20));
		keys.add(new Key(200,220));
		
		keys.add(new Key(1200,1220));
		keys.add(new Key(1250,1280));
		keys.add(new Key(1400,1520));
		keys.add(new Key(1700,1820));
				
		printRanges(getRanges(shards, keys));
	}

	private static void printRanges(List<Range> ranges) {
		for (Range range : ranges) {
			System.out.print(range.i + "-" + range.j + ",");
		}		
	}

	public static List<Range> getRanges(List<Shard> shards, List<Key> keys) {
		List<Range> r = new ArrayList<>();				
		Range range = null;
		int i = 0;
		int j = 0;
		Shard shard = null;
		Key key = null;
				
		while (i < shards.size() && j < keys.size()) {
			shard = shards.get(i);
			if (range == null) {
				range = new Range();
				range.i = Math.max(shard.i, keys.get(j).i);
			}
			
			while(j < keys.size()) {
				key = keys.get(j);
				
				if (shard.i <= key.i && shard.j >= key.j) {
					j++;
				} else if (shard.j < key.i) {
					range.j = j > 0 ? Math.min(keys.get(j - 1).j, shard.j) : shard.j;
					r.add(range);					
					i++;					
					range = null;
					break;
				} else if (shard.j > key.i && shard.j < key.j) {
					i++;
					j++;
					break;
				} else {
					j++;
				}
			}
		}
		
		if (i < shards.size() && range.j == 0 && j > 0) {
			range.j = Math.min(keys.get(j - 1).j, shard.j);
			r.add(range);								
		}

		return r;
	}
	
}
class Range {
	int i;
	int j;
	public Range() {}
	public Range(int i, int j) {
		this.i = i;
		this.j = j;
	}
	@Override
	public String toString() {
		return i + " - " + j;
	}			
}
class Shard extends Range {
	public Shard(int i, int j) {
		super(i,j);
	}
}
class Key extends Range {
	public Key(int i, int j) {
		super(i,j);
	}	
}
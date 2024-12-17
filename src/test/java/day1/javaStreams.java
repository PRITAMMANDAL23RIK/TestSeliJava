package day1;

import java.util.ArrayList;

public class javaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<String>();
		names.add("Rik");
		names.add("Pinku");
		names.add("Riku");
		names.add("iik");
		names.add("Riko");
		Long c=names.stream().filter(s->s.startsWith("R")).count();
		System.out.println(c);
		names.stream().filter(s->s.length()>=4).limit(2).forEach(s->System.out.println(s));
		names.stream().filter(s->s.endsWith("u")).map(a->a.toUpperCase()).forEach(b->System.out.println(b));

	}

}

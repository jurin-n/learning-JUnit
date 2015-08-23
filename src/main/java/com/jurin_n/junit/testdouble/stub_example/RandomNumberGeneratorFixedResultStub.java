package com.jurin_n.junit.testdouble.stub_example;

public class RandomNumberGeneratorFixedResultStub implements RandomNumberGenerator {

	@Override
	public int nextInt() {
		return 1;
	}

}

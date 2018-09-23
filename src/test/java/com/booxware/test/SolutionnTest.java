package com.booxware.test;

import com.nortal.testassignment.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SolutionnTest {

	@Test
	public void test1() throws Exception {
		test(
			"rO0ABXNyAChjb20ubm9ydGFsLnRlc3Rhc3NpZ25tZW50LlNvbHV0aW9uJE1vbmV5fcOyKnEpkOsCAAFJAAV2YWx1ZXhwAAAACg==",
			"value",
			100,
			"rO0ABXNyAChjb20ubm9ydGFsLnRlc3Rhc3NpZ25tZW50LlNvbHV0aW9uJE1vbmV5fcOyKnEpkOsCAAFJAAV2YWx1ZXhwAAAAZA=="
		);
	}

	@Test
	public void test2() throws Exception {
		test(
			"rO0ABXNyADRjb20ubm9ydGFsLnRlc3Rhc3NpZ25tZW50LlNvbHV0aW9uJE1vbmV5V2l0aEN1cnJlbmN564gdEMbOaSMCAAJJAAZhbW91bnRMAAhjdXJyZW5jeXQAEkxqYXZhL2xhbmcvU3RyaW5nO3hwAAAAFHQAAA==",
			"amount",
			50,
			"rO0ABXNyADRjb20ubm9ydGFsLnRlc3Rhc3NpZ25tZW50LlNvbHV0aW9uJE1vbmV5V2l0aEN1cnJlbmN564gdEMbOaSMCAAJJAAZhbW91bnRMAAhjdXJyZW5jeXQAEkxqYXZhL2xhbmcvU3RyaW5nO3hwAAAAMnQAAA=="
		);
	}

	@Test
	public void test3() throws Exception {
		test(
			"rO0ABXNyAD1jb20ubm9ydGFsLnRlc3Rhc3NpZ25tZW50LlNvbHV0aW9uJE1vbmV5V2l0aEN1cnJlbmN5QW5kU2VyaWFsuqZsiGo8930CAANJAAdfYW1vdW50TAAJX2N1cnJlbmN5dAASTGphdmEvbGFuZy9TdHJpbmc7TAAHX3NlcmlhbHEAfgABeHAAAABkdAAAcQB+AAM=",
			"_amount",
			1,
			"rO0ABXNyAD1jb20ubm9ydGFsLnRlc3Rhc3NpZ25tZW50LlNvbHV0aW9uJE1vbmV5V2l0aEN1cnJlbmN5QW5kU2VyaWFsuqZsiGo8930CAANJAAdfYW1vdW50TAAJX2N1cnJlbmN5dAASTGphdmEvbGFuZy9TdHJpbmc7TAAHX3NlcmlhbHEAfgABeHAAAAABdAAAcQB+AAM="
		);
	}
	
	void test(String base64ObjectInput, String fieldName, int newValue, String expectedBase64ObjectOutput) throws Exception {

		assertEquals(expectedBase64ObjectOutput, Solution.penetrate(base64ObjectInput, fieldName, newValue));
	}

}

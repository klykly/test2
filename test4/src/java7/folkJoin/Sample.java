package java7.folkJoin;

import java.util.Arrays;
import java.util.concurrent.*;

public class Sample {
	public static void main(String[] args) {
		ForkJoinPool threadPool = new ForkJoinPool();

		int[] values = new int[] { 11,10, 3, 4,12, 1, 2, 5, 7, 9 };

		threadPool.invoke(new SortTask(values, new int[10], 0, 9));

		System.out.println(Arrays.toString(values));
	}

	private static class SortTask extends RecursiveAction {
		private int[] a;
		private int[] tmp;
		private int lo, hi;

		public SortTask(int[] a, int[] tmp, int lo, int hi) {
			this.a = a;
			this.lo = lo;
			this.hi = hi;
			this.tmp = tmp;
		}

		@Override
		protected void compute() {
			if (hi == lo) {
				return;
			}

			int m = (lo + hi) / 2;

			invokeAll(new SortTask(a, tmp, lo, m), new SortTask(a, tmp, m+1, hi));
			merge(a, tmp, lo, m, hi);
		}
	}

	private static void merge(int[] a, int[] b, int lo, int m, int hi) {
		System.out.println(m);
		if (a[m] <= a[m+1])
			return;

		System.arraycopy(a, lo, b, lo, m-lo+1);

		int i = lo;
		int j = m+1;
		int k = lo;

		while (k < j && j <= hi) {
			if (b[i] <= a[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = a[j++];
			}
		}

		System.arraycopy(b, i, a, k, j-k);
	}
}
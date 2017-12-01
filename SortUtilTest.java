package com.andrew.threads;

public class SortUtilTest {
	
	
	private static int n = 50000;
	private static int max = 100000;
	
	
	public static void main(String[] args) {
		testDirectInsertionSort();
		testShellSort();
		testSimpleSelectionSort();
		testSimpleSelectionSort2();
		testHeapSort();
		testBubbleSort();
		testBubbleSort2();
		testBubbleSort3();
		testBubbleSort4();
		testQuikSort();
		testQuikSort1();
		testQuikSort2(6);
		testMergeSort();
	}

	
	public static void testDirectInsertionSort() {
		System.out.println("\r\nDirect Insertion Sort-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.insertionSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testShellSort() {
		System.out.println("\r\nShell Sort-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.shellSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testSimpleSelectionSort() {
		System.out.println("\r\nSimple Selection Sort-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.simpleSelectionSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testSimpleSelectionSort2() {
		System.out.println("\r\nSimple Selection Sort2-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.simpleSelectionSort2(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	

	public static void testHeapSort() {
		System.out.println("\r\nHeap Sort-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.heapSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testBubbleSort() {
		System.out.println("\r\nBubble Sort-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.bubbleSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testBubbleSort2() {
		System.out.println("\r\nBubble Sort2-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.bubbleSort2(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testBubbleSort3() {
		System.out.println("\r\nBubble Sort3-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.bubbleSort3(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testBubbleSort4() {
		System.out.println("\r\nBubble Sort4-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.bubbleSort4(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testQuikSort() {
		System.out.println("\r\nQuick Sort-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.quickSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testQuikSort1() {
		System.out.println("\r\nQuick Sort 1 Swap 2-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.quickSort2(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testQuikSort2(int k) {
		System.out.println("\r\nQuick Sort2-----------------------------------");
		Integer[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		SortUtil.quickSort(a, k);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}
	
	public static void testMergeSort() {
		System.out.println("\r\nMerge Sort-----------------------------------");
		Comparable[] a = SortUtil.getRandomInts(n, max);
		long c = System.currentTimeMillis();
		a = SortUtil.mergeSort(a);
		System.out.println("耗时 " + (System.currentTimeMillis() - c));
		System.out.println("排序 " + (SortUtil.judgeOrders(a)?"成功":"失败"));
	}

}

package com.andrew.threads;

import java.util.Random;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SortUtil {

	/**
	 * 直接插入排序
	 * @param a 表
	 */
	public static void insertionSort(Comparable[] a) {
		insertionSort(a, 0, 1);
	}
	
	/**
	 * 希尔排序
	 * @param a 表
	 */
	public static void shellSort(Comparable[] a) {
		int dk = a.length / 2; // 初始增量
		while (dk >= 1) {
			for(int c = 0; c < dk; c++){// 做 dk 趟排序
				insertionSort(a, c, dk);//将子序列按直接插入排序
			}
			dk = dk / 2; // dk 降低
		}
	}
	
	/**
	 * 对子表进行直接插入排序
	 * @param a 表
	 * @param c 起始位置
	 * @param dk 步长
	 */
	private static void insertionSort(Comparable[] a, int c, int dk){
		for (int i = c+dk; i < a.length;) {
			if (a[i].compareTo(a[i - dk]) < 0) {
				Comparable x = a[i];
				int j = i - dk;
				while (j >= c && x.compareTo(a[j]) < 0) {
					a[j + dk] = a[j];
					j -= dk;
				}
				a[j + dk] = x;
			}
			i += dk;
		}
	}
	
	/**
	 * 简单选择排序
	 * @param a 表
	 */
	public static void simpleSelectionSort(Comparable[] a){
		for(int i = 0; i < a.length - 1; i++){
			int index = minIndex(a, i);
			if(i != index){
				Comparable x = a[i];
				a[i] = a[index];
				a[index] = x;
			}
		}
	}
	
	/**
	 * 计算给定表中最小位置索引
	 * @param a 表
	 * @param start 起始位置
	 * @return
	 */
	private static int minIndex(Comparable[] a, int start){
		if(start >= a.length)
			throw new IllegalArgumentException("Start position can't be greater than array length : " + start);
		int index = start;
		for(int i = start + 1;i < a.length; i ++){
			if(a[i].compareTo(a[index]) < 0)
				index = i;
		}
		return index;
	}
	
	/**
	 * 二元选择排序
	 * @param a 表
	 */
	public static void simpleSelectionSort2(Comparable[] a){
		int i, j, min, max;
		Comparable tmp;
		int n = a.length;
		for(i = 0; i < n/2; i++){
			min = i; 
			max = i;
			for(j = i+1; j < n-i; j++){
				if(a[j].compareTo(a[max]) > 0){
					max = j;
					continue;
				}
				if(a[j].compareTo(a[min]) < 0)
					min = j;
			}
			tmp = a[i]; 
			a[i] = a[min]; 
			a[min] = tmp;
			
			if(max == i){
				tmp = a[n-i-1];
				a[n-i-1] = a[min];
				a[min] = tmp;
			}else{
				tmp = a[n-i-1];
				a[n-i-1] = a[max];
				a[max] = tmp;
			}
		}
	}
	
	/**
	 * 堆排序
	 * @param a 表
	 */
	public static void heapSort(Comparable[] a){
		buildHeap(a);//将无序表构造为大顶堆
		for(int i = a.length - 1; i > 0; i--){//不断将根节点后置, 然后将n-i(0<i<length)子树重置为大顶堆
			Comparable tmp = a[i]; 
			a[i] = a[0]; 
			a[0] = tmp;
			adjustHeap(a,0,i);
		}
	}
	
	/**
	 * 将线性表构造成堆
	 * @param a
	 */
	private static void buildHeap(Comparable[] a){
		for(int i = (a.length-1)/2; i >= 0; i--)//从最后子树根节点开始, 调整子树使其成堆
			adjustHeap(a, i, a.length);
	}
	
	/**
	 * 调整子树,使其成堆
	 * @param a 节点存储表/数组
	 * @param root 当前根节点
	 * @param length 当前子树节点数
	 */
	private static void adjustHeap(Comparable[] a, int root, int length){
		Comparable tmp = a[root];
		int child = 2*root+1;
		while(child < length){
			if(child + 1 < length && a[child].compareTo(a[child+1]) < 0){//取最大子
				++child;
			}
			if(a[root].compareTo(a[child]) < 0){//若根小于最大子, 则交换
				a[root] = a[child];
				root = child;
				child = 2*root+1;
				a[root] = tmp;
			} else{//若根大于最大子, 则子树已经成堆, 无须调整
				break;
			}
		}
	}
	
	
	/**
	 * 冒泡排序 O(n!)
	 * @param a 表
	 */
	public static void bubbleSort(Comparable[] a){
		for(int i = 0; i < a.length - 1; i++){
			for(int j = 0; j < a.length - i - 1; j ++){
				if(a[j].compareTo(a[j+1]) > 0){
					Comparable tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	
	
	/**
	 * 优化冒泡 1
	 * 若序列已经有序, 则可以立即终止
	 * @param a 表
	 */
	public static void bubbleSort2(Comparable[] a){
		boolean exchange = true;
		for(int i = 0; exchange && i < a.length - 1; i++){
			exchange = false;
			for(int j = 0; j < a.length - i -1; j++){
				if(a[j].compareTo(a[j+1]) > 0){
					Comparable tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					exchange = true;
				}
			}
		}
	}
	
	/**
	 * 优化冒泡2
	 * 记录最后交换位置position,position后为已经有序序列,
	 * 只需检查比较position前的序列
	 * @param a 表
	 */
	public static void bubbleSort3(Comparable[] a){
		int i = a.length - 1;
		while(i > 0){
			int pos = 0;
			for(int j = 0; j < i; j ++){
				if(a[j].compareTo(a[j+1]) > 0){
					pos = j;
					Comparable tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
			i = pos;
		}
	}
	
	/**
	 * 优化冒泡3
	 * 双向冒泡, 一次同时找出最大和最小值
	 * @param a 表
	 */
	public static void bubbleSort4(Comparable[] a){
		int low = 0;
		int high = a.length - 1;
		int j;
		Comparable tmp = null;
		
		while(low < high){
			for(j = low; j < high; j++){
				if(a[j].compareTo(a[j+1]) > 0){
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
			--high;
			for(j = high; j > low; j--){
				if(a[j].compareTo(a[j-1]) < 0){
					tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
			}
			++low;
		}
	}
	
	/**
	 * 快速排序 O(nlogn)
	 * 递归实现, 易栈溢出
	 * @param a 表
	 */
	public static void quickSort(Comparable[] a){
		int low = 0;
		int high = a.length - 1;
		swap(a, low, high, 0);
	}
	
	/**
	 * 快速排序 优化 
	 * 使用快速排序使表局部有序, 再调用插入排序进行排序
	 * @param a 表
	 * @param k 步长
	 */
	public static void quickSort(Comparable[] a, int k){
		int low = 0;
		int high = a.length - 1;
		swap(a, low, high, k);
		insertionSort(a);
	}
	
	/**
	 * 快速排序 O(nlogn)
	 * 递归实现, 易栈溢出
	 * @param a 表
	 */
	public static void quickSort2(Comparable[] a){
		int low = 0;
		int high = a.length - 1;
		swap2(a, low, high, 0);
	}
	
	/**
	 * 递归分组快排
	 * @param a 表
	 * @param l 起始位置
	 * @param h 结束位置
	 * @param k 步长
	 */
	private static void swap(Comparable[] a, int l, int h, int k){
		if(l + k >= h)
			return;
		Comparable base = a[l];
		int s = l;
		int j = l+1;
		for(int i = l+1; i <= h; i++){
			if(a[i].compareTo(base) < 0){
				Comparable tmp = a[l];
				a[l] = a[i];
				a[i] = a[j];
				a[j] = tmp;
				l = j;
				j++;
			}
		}
		swap(a, s, l-1, k);
		swap(a, l+1, h, k);
	}
	
	/**
	 * 递归分组快排2 两头寻找替换
	 * @param a
	 * @param l
	 * @param h
	 * @param k
	 */
	private static void swap2(Comparable[] a, int l, int h, int k){
		if(l + k >= h)
			return;
		Comparable base = a[l];
		int i = l;
		int j = h;
		while(i < j){
			while(i < j && a[j].compareTo(base) >= 0)
				j--;
			while(i < j && a[i].compareTo(base) < 0)
				i++;
			if(i == j && a[i].compareTo(base) < 0){
				a[l] = a[j];
				a[j] = base;
			}else if( i != j){
				Comparable tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		swap2(a, l, i - 1, k);
		swap2(a, i + 1, h, k);
		
	}
	
	/**
	 * 归并排序 迭代实现
	 * @param a 表
	 * @return a 有序表
	 */
	public static void mergeSort(Comparable[] a){
		Comparable[] b = new Comparable[a.length];//临时表,用以存放合并数据
		int len = 1;// 初始子表长度 从1开始
		while(len < a.length){
			int s = len;//缓存单子表长度,用以计算移动步长
			len = 2*s;//两张子表长度,用以计算移动步长
			int i = 0;//左子表起始位置
			while(i + len <= a.length){//若本轮未合并主表含两个及以上长度为len的子表, 则进行两两合并
				mergeOptimize(a, b, i, i + s - 1, i + len -1);//合并子表
				i = i + len;//左子表起始位置变更为下一个未合并子表
			}
			if(i + s < a.length){//若本轮未合并主表仅剩下两个不等长子表,将其合并(合并后排序完成. 仅当a.length = 2*k + 1 时有此情况)
				mergeOptimize(a, b, i, i + s - 1, a.length - 1);
			}
		}
	}
	
	/**
	 * 两路归并排序 递归实现
	 * @param a
	 * @return
	 */
	public static void mergeSortRecursive(Comparable[] a){
		Comparable[] b = new Comparable[a.length];
		recursiveMerge(a, b, 0, a.length - 1);
	}
	
	/**
	 * 递归合并
	 * @param a 原表
	 * @param b 结果表
	 * @param s 开始位置
	 * @param t 结束位置
	 */
	private static void recursiveMerge(Comparable[] a, Comparable[] b, int s, int t){
		if(s < t){
			int m = (s+t)/2;
			recursiveMerge(a, b, s, m);
			recursiveMerge(a, b, m+1, t);
			mergeOptimize(a, b, s, m, t);
		}
	}
	
	/**
	 * 合并子表优化版
	 * 优化临时表拷贝到原表, 所有结果存储在原表中
	 * @param a
	 * @param tmp
	 * @param l
	 * @param m
	 * @param h
	 */
	private static void mergeOptimize(Comparable[] a, Comparable[] tmp, int l, int m, int h){
		int i = l;
		int j = m + 1;
		int c = 0;
		while(i <= m && j <= h){
			if(a[i].compareTo(a[j]) <= 0){
				tmp[c++] = a[i++];
			} else{
				tmp[c++] = a[j++];
			}
		}
		while(i <= m){
			tmp[c++] = a[i++];
		}
		while(j <= h){
			tmp[c++] = a[j++];
		}
		for(int k = 0; k < c; k ++){
			 a[l + k] = tmp[k];
		}
	}
	
	
	
	/**
	 * 基数排序   箱排序优化
	 * @param a 表
	 */
	public static void radixSort(Integer[] a, int k, int r){
		int n = a.length;
		Integer[] tmp = new Integer[n];
		Integer[] ex = null;
		int[] cnt = new int[r];
		for(int i = 0, rtok = 1; i < k; i++, rtok = rtok * r){//循环数据位数,对每个数位进行箱排序
			for(int j=0; j < r; j++)//将位置索引清空
				cnt[j] = 0;
			
			for(int j = 0; j < n; j++)// 计算当前数位各个数位置索引
				cnt[(a[j]/rtok)%r]++;
			
			for(int j = 1; j < r; j++)// 迭加前面的索引, 计算正确索引位置(存在相等数,因此需要迭加)
				cnt[j] = cnt[j-1] + cnt[j];
			
			for(int j = n - 1; j >= 0; j--){//将序列中各数按照当前数位计算的索引进行放置
				cnt[(a[j]/rtok)%r]--;//相同索引位置放置时,索引-1
				tmp[cnt[(a[j]/rtok)%r]] = a[j];//将序列中的数放置到正确索引位置
			}
			ex = tmp;
			tmp = a;
			a = ex;
		}
	}
	
	
	/**
	 * 判断给定表是否有序
	 * @param a 表
	 */
	public static boolean judgeOrders(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(a[i-1].compareTo(a[i]) > 0)
				return false;
		}
		return true;
	}
	
	/**
	 * 打印数组
	 * @param prefix 前缀
	 * @param a 数组
	 */
	public static void print(String prefix, Object[] a) {
		StringBuilder bf = new StringBuilder(prefix);
		if(a != null){
			bf.append("[");
			for (Object c : a) {
				bf.append(c.toString()).append(" ");
			}
			bf.append("]");
		}
		System.out.println(bf.toString());
	}

	/**
	 * 获取随机数数组
	 * @param n 数组容量
	 * @param max 生成域(0 < k < max)
	 * @return
	 */
	public static Integer[] getRandomInts(int n, int max) {
		Integer[] a = new Integer[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(max);
		}
		return a;
	}

}

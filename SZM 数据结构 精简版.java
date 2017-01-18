广度优先搜索用队列，截止条件是queue.isEmpty()
深度优先搜索(迭代版)用堆栈，截止条件是stack.isEmpty()
深度优先搜索(迭代版)无法进行后序遍历，个人感觉！！！

//=============Java版本的广度优先搜索=============
public void bfs(Node root) {
	if (root == null)
		return;
	Queue<Node> q = new LinkedList<Node>();	//注意：这种"LinkedList"形式创建队列
	q.add(root); //q.offer(root);
	while (!q.isEmpty()) {
		Node n = (Node) q.remove(); //q.poll();
		System.out.print(" " + n.data);
		if (n.left != null)
			q.add(n.left);
		if (n.right != null)
			q.add(n.right);
	}}
//=============Java版本的深度优先搜索(迭代版本)=============
public void dfs1(TreeNode root) {
	List<Integer> result = new List<Integer>();	//存储结果
	//if (root == null) return;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode node = root;
	while (node != null || !stack.isEmpty()) {
		if (node != null) {
			stack.push(node);
			//result.add(node.value); //先序遍历数据处理的范围
			node = node.left;
		} else {
			node = stack.pop();	//相当于两个动作，先取top的数据(peek())，在删除它的空间
			//result.add(node.value); //中序遍历处理数据的范围
			node = node.right;	//<==这条语句很关键
		}
	}
	return;}

public void dfs2(TreeNode root) {
	List<Integer> result = new List<Integer>();	//存储结果
	if (root == null) return;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);

	while (!stack.isEmpty()) {
		TreeNode node = stack.peek();	//读取最新压入栈的top节点
		if (node.left != null) {
			stack.push(node.left);
			//result.add(node.value); //先序遍历数据处理的范围???
			node.left = null;	//很关键，避免在堆栈返回的时候，陷入循环！？
		} else {
			//result.add(node.value); //中序遍历处理数据的范围
			//一定要pop出栈，不然之后会重复进行读取peek()
			stack.pop();	// node=stack.pop()，这样的效果跟"stack.pop()"其实一样
			if (node.right != null) {
				stack.push(node.right);
			}
		}
	}
	return;}

//=============根据pivot，把数据Partition成两组=============
// Note: "++leftPtr"和"--rightPtr" 是这是正确的，不能放在while内，否者条件不满足时不能加1，陷入死循环!!!

private long[] theArray;	// ref to array theArray
public int partitionIt(int left, int right, long pivot)
{
	// "leftPtr=left-1" 是因为 "++leftPtr" 的缘故，故需要提前减一
	int leftPtr = left - 1;           	// right of first elem
	int rightPtr = right + 1;         	// left of pivot
	while(true)
	{
		//"leftPtr<right"没有用"<="，是因为它会在数组全等的情况下，leftPtr和rightPtr会停留在数组两端
		while(leftPtr < right && 		// find bigger item     	
			theArray[++leftPtr] < pivot)
		;  // (nop)
		while(rightPtr > left &&       	// find smaller item
			theArray[--rightPtr] > pivot)
		;  // (nop)
		if(leftPtr >= rightPtr)        	// if pointers cross,
			break;                      //    partition done
		else                           	// not crossed, so
			swap(leftPtr, rightPtr);	//    swap elements
	}
	return leftPtr;                   	// return partition}

//=============inorder traverse中序遍历=============
private void inOrder(node root)
{
	if(root != null)
		return;
	inOrder(root.leftChild);
	System.out.print(root.iData + " ");
	inOrder(root.rightChild);}

//==========Java STDIN and STDOUT 模板==========
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))
String inStr1 = stdin.readLine();
String inStr2 = stdin.readLine();
System.out.println(...);
System.out.println(...);

//集中关键数据结构的申明
//=============================StringBuilder============================
StringBuilder newString = new StringBuilder();
newString.append('s'); newString.append('z'); 	// append('X')
System.out.println(newString.toString()); 		// newString.toString()

//=============================StringBuffer类似============================
......

//=============================字符串操作============================
char c = str.charAt(i); 			// 获得第i个位置的字符
int position = str.indexOf(c); 		// -1(表示找不到) or 返回第一次出现子字符串的字符位置
boolean result = str.contains(c); 	// true or false
XXX = str1.equalsIgnoreCase(str2); 	// 字符串是否相同比较，不考虑大小写
XXX = str1.equals(str2);			// 字符串是否相同比较，考虑大小写
String[] str1 = str.split(",");		// 按逗号分成几段，str1[0]是第一段字符串

int IntType = Integer.parseInt(StringType);		//把String变成Int
String StringType = Integer.toString(IntType);	//把Int变成String
String str = IntType + "";						//把Int变成String，只需添加一个""

//===========================Stack==============================
Stack<String> s = new Stack<String>();
s.push("aa"); 	// 入栈
XXX = s.pop(); 	// 出栈
XXX = s.peek();	// peek at top of stack
if(s.isEmpty() == 1)	// check whether it is empty
	System.out.println("it is empty!");
	
//=============================PriorityQueue(heap)============================
PriorityQueue<MyThread> q = new PriorityQueue<MyThread>(XX, new Comparator<MyThread>() {
    public int compare(MyThread o1, MyThread o2)
	{return o1.weight - o2.weight;}});
q.offer(new MyThread(5));
XXX = q.poll();

//==========================Java快速排序，效果跟PriorityQueue类似==========================
import java.util.*; //这句话重要
//这里把cost小的往前排, 注意： inputList is List类型
Collections.sort(inputList, new Comparator<classXX>() {
	@Override
	public int compare(classXX o1, classXX o2) {
		return o1.cost - o2.cost;
	}});

//===========================ArrayList==============================
List<Integer> List = new ArrayList<Integer>(); //指定了Integer对象
List.add(1);
List.set(0,12);		//注意: set(...,...)设置某个特定的element
list.get(i);		//注意: 从list列表中获取元素要使用get(...)函数
list.remove(0);		//删除头部

//=============================Queue============================
Queue<Integer> q = new LinkedList<Integer>();  //LinkedList封装了Queue的接口
poll(), remove(), peak(), add(), offer()方法
q.poll() = q.remove()
q.add() = q.offer()

//=============================HashMap============================
HashMap<String, String> hashMap = new HashMap<String, String>(); // <key, content>
hashMap.put("cn", "中国");
XXX = hashMap.get("cn");
System.out.println("cn:" + hashMap.get("cn"));	//输出: cn:中国
System.out.println(hashMap.containsKey("cn"));	//输出: true
System.out.println(hashMap.isEmpty());			//输出: false
hashMap.remove("cn"); //<<<<<<<<<<<<很重要！！！去除一个元素
//=============hashMap最经典的一种遍历=============
//注意: 这里假设key和value的类型都是String
for (String key : map.keySet()){
	//String value = map.get(key);}
//=============hashMap第二种遍历方法=============
Iterator it = hashMap.keySet().iterator();  //采用Iterator遍历HashMap
while(it.hasNext()) {  
	String key = (String)it.next();  
	System.out.println("key:" + key);  
	System.out.println("value:" + hashMap.get(key));  }

//=============对于无序的数组，hashmap表可以用来统计字符串出现的次数=============
在hashmap中，key为“字符串”，value为“字符串出现次数”；
如果字符串已存在，将键为该字符串的值加1，否则添加键值对 “字符串—>出现次数1”
if (map.containsKey(str)) { 
	map.put(str, map.get(str) + 1);} else { 
	map.put(str, 1); //表示出现第1次} 

//=====================MergeSort归并排序=====================
private void recMergeSort(long[] workSpace, int lowerBound, int upperBound)
{
	if(lowerBound < upperBound)    //？？？？？？
	{                             		
		int mid = (lowerBound+upperBound) / 2;		// find midpoint
		recMergeSort(workSpace, lowerBound, mid);	// sort low half
		recMergeSort(workSpace, mid+1, upperBound);	// sort high half
		merge(workSpace, lowerBound, mid+1, upperBound);	// merge them
	}}

//=====================================================
//====================回文算法O(n)=====================
//=====================================================

//=====================================================
//============用二分查找法(while循环实现)==============
//=====================================================
public int find(long searchKey)
{
	int lowerBound = 0;
	int upperBound = nElems-1;	//注意减1
	int curIn;
	while(true)
	{
		curIn = (lowerBound + upperBound ) / 2;
		if(a[curIn]==searchKey)
			return curIn;              	// found it
		else if(lowerBound > upperBound)// 当"lowerBound=upperBound"时，表示还需要进行一轮循环
			return nElems;             	// can’t find it，也可以返回"-1"???
		else                          	// divide range
		{
			if(a[curIn] < searchKey)
				lowerBound = curIn + 1; // it’s in upper half
			else
				upperBound = curIn - 1; // it’s in lower half
		}
	}}

//=====================QuickSort快速排序=====================
//Idea：使用pivot去partition一个数组，然后用devide-and-conquar去进行递归

private long[] theArray;	// ref to array theArray
public void recQuickSort(int left, int right)
{
	if(right-left <= 0)              	// if size <= 1,
		return;                      	//    already sorted
	else                             	// size is 2 or larger
	{
		long pivot = theArray[right];      // rightmost item
		// partition range
		int partition = partitionIt(left, right, pivot);
		recQuickSort(left, partition-1);   // sort left side
		recQuickSort(partition+1, right);  // sort right side
	}}

// 从两端向中间搜索，截止条件是：leftPtr>=rightPtr
public int partitionIt(int left, int right, long pivot)
{
	int leftPtr = left-1;           // left    (after ++)
	int rightPtr = right;           // right-1 (after --)，因为最右边是pivot
	while(true)
	{
		//"leftPtr<right"没有用"<="，是因为它会在数组全等的情况下，leftPtr和rightPtr会停留在数组两端
		while(theArray[++leftPtr] < pivot)	// find bigger item
		;  // (nop)
		while(rightPtr > left &&       		// find smaller item
			theArray[--rightPtr] > pivot)
		;  // (nop)
		if(leftPtr >= rightPtr)        	// if pointers cross,
			break;                      //    partition done
		else                           	// not crossed, so
			swap(leftPtr, rightPtr);	//    swap elements
	}
	//下面是快速排序中特有的很关键的一句！！！
	swap(leftPtr, right);           	// restore pivot
	return leftPtr;                   	// return partition}
//如何使用：
partitionIt(0, Array.size()-1, pivot); //

//============================================================

//========================================================================================
//====================================Java基础知识总结====================================
//========================================================================================
对象和引用(reference)关系：Thermostat therm1 = new Thermostat(); // new在java中返回一个引用
Java对基本数据类型(byte，int，short，long，boolean，char，float，double)的处理与对象的处理不同。
int test;			//一个含数据空间的值
Thermostat therm1;	//Java中创建一个为null的引用; 然而在C++中，它创建一个对象并留出数据空间
therm1 = therm2;	//Java中只是拷贝存储地址，但在C++中，therm2对象的所有数据拷贝到therm1对象中
if(therm1 == therm2);	//Java中判断的是引用是否指向同一个对象，但在C++中，判断两个对象是否含相同的数据
Java中，一个int永远是32位，而在C和C++中，int大小取决于运行的计算机。
Java中，float和long类型需要加后缀，比如：3.14159F，4567774L

与C++不同的是，Java把数组当对象来对待，因此在创建对象时必须使用new，比如：
int[] intArray; intArray = new int[100]; //数组有一个length字段，它知道当前数组大小
autoData test = new autoData[100];
一种初始化方法(省略了new)：int[] intArray = {0, 1, 2, 3};

Java输入字符串比C和C++麻烦：
public static String getString() throws IOException
{
	InputStreamReader isr = new InputStreamReader(System.in); //通过回车终止
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;}
String s = getString();
s.charAt(0);			//提取String的第一个元素
String s = getString();
Integer.parseInt(s);	//把String转换成int类型

//For float and double, the conversion process is more complex.
String s = getString();
Double aDub = Double.valueOf(s);//把String转换成Double类型
aDub.doubleValue();
Float aFlo = Float.valueOf(s);	//把String转换成Float类型
aFlo.floatValue();

final关键字使用:
final class can't be inherited; 
final method can't be overridden; 
final variable value can't be changed.

Collection
├List
│├LinkedList
│├ArrayList
│└Vector
│　└Stack
└Set
Java数据结构总结：
如果涉及到堆栈，队列等操作，应该考虑用List(派生了LinkedList和ArrayList)，
对于需要快速插入，删除元素，应该使用LinkedList，
如果需要快速随机访问元素，应该使用ArrayList。

## HashMap vs. TreeMap vs. HashTable vs. LinkedHashMap
+ Overview
  - HashMap: implemented as a hash table, no ordering on keys or values
  - TreeMap: implemented based on red-black tree, ordered by key
  - LinkedHashMap: preserves insertion order
  - HashTable: synchronized in constrast to HashMap
  
//==========Java STDIN and STDOUT 模板==========
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))
String inStr1 = stdin.readLine();
String inStr2 = stdin.readLine();
System.out.println(...);
System.out.println(...);

//========================================================================================

//======================Java数据类型最大值和最小值======================
Java中提供了long、int、short、及byte四种整数类型的最大值、最小值的代码。
最大值方法定义为MAX_VALUE，最小值定义为MIN_VALUE，在使用时分别加上类名就行了。
以MAX_VALUE为例：
java.lang.Long.MAX_VALUE 	(9223372036854775807 ~ -9223372036854775808)
java.lang.Integer.MAX_VALUE	(2147483647 ~ -2147483648)
java.lang.Short.MAX_VALUE	(32767 ~ -32768)
java.lang.byte.MAX_VALUE	(127 ~ -128)
java.lang.Integer.MIN_VALUE

//======================Java数据类型======================
基本数据类型：byte，int，short，long，boolean，char，float，double等
Wrapper类型：
Byte，Integer，Short，Long，Boolean，Character，Float，Double等

//===================java中区别：sum +=i和sum=+i===================
sum += i;  	//相当于 sum = sum + i
sum = +i; 	//相当于sum = i，这个就是相当于一个赋值了，而上者是相互加再赋值

//======================LinkedList 和 ArrayList重要区别======================
LinkedList接口 在代码的使用过程中和ArrayList没有什么区别
ArrayList底层是object数组，所以ArrayList具有数组的查询速度快的优点以及增删速度慢的缺点。
而在LinkedList的底层是一种双向循环链表。在此链表上每一个数据节点都由三部分组成：
前指针(指向前面的节点的位置)，数据，后指针(指向后面的节点的位置)。
最后一个节点的后指针指向第一个节点的前指针，形成一个循环。 
双向循环链表的查询效率低但是增删效率高。所以LinkedList具有查询效率低但增删效率高的特点。
ArrayList和LinkedList在用法上没有区别，但是在功能上还是有区别的。

LinkedList经常用在增删操作较多而查询操作很少的情况下：队列和堆栈。
队列：先进先出的数据结构。
堆栈：后进先出的数据结构。
注：使用堆栈的时候一定不能提供方法让不是最后一个元素的元素获得出栈的机会。
LinkedList提供以下方法：(ArrayList无本类方法)
addFirst(); 
removeFirst();
addLast();
removeLast();

在堆栈中，push为入栈操作，pop为出栈操作。
Push用addFirst()；pop用removeFirst()，实现后进先出。
用isEmpty()--其父类的方法，来判断栈是否为空。
 
在队列中，put为入队列操作，get为出队列操作。
Put用addFirst()，get用removeLast()实现队列。

//======================Java StringTokenizer使用举例======================
StringTokenizer st = new StringTokenizer("this is test");
while (st.hasMoreTokens())
	{System.out.println(st.nextToken());}
打印出来之后是：
this
is
test
//==========效果跟使用split一样==========
String[] result = "this is test".split("\\s"); //或者"\\t" ???
for (int x=0; x<result.length; x++)
	System.out.println(result[x]);

//=============对于无序的数组，hashmap表可以用来统计字符串出现的次数=============
在hashmap中，key为“字符串”，value为“字符串出现次数”；
如果字符串已存在，将键为该字符串的值加1，否则添加键值对 “字符串—>出现次数1”
if (map.containsKey(str)) { 
	map.put(str, map.get(str) + 1);} else { 
	map.put(str, 1); //此处应该是1吧，表示出现1次，0也可以？}

//============== Java 常数类型转换 ==============
1d -- 表示它是double类型
3.14f -- 表示它是float类型
7778889933l -- 'l'表示它是long类型

//============== 函数重载用以实现"函数同名，但参数不同" ==============
/**在forward()内部调用它的重载形式：forward(input, hidden, iptHidWeights)*/
private void forward() {
	forward(input, hidden, iptHidWeights);	//在神经网络中，某人用到了这个
	forward(hidden, output, hidOptWeights);}
private void forward(double[] layer0, double[] layer1, double[][] weight) {
	//......}

//============== 条件判断语句 ==============
// log2(x) = log(x) / log(2), and x could not be zero
public static double log2(double x) {
	 return x == 0 ? 0 : (Math.log(x)/Math.log(2)); //条件判断语句}
  
//==============java中的Scanner输入一定要以某个符号结束==============
>>> 数据库中的应用
Scanner scanner = new Scanner(System.in).useDelimiter(";");

//============== java中的 计时函数 ==============
long timeStart = System.currentTimeMillis();
//......
long timeEnd = System.currentTimeMillis();
System.out.println("The Whole time is " + (timeEnd - timeStart));
			
//============== java中的三种取整函数 ==============
向上取整: Math.ceil(3.1)=4
向下取整: Math.floor(3.5)=3
四舍五入取整: Math.rint(3.5)=4

/** 千万注意：Java的平方根不是 x^2，而是 Math.pow(x,2) */
Math.pow(x,y) ：x的y次方
Math.sqrt(x) ：开平方根
Math.E = Math.exp(1) = 2.718281828459045
Math.exp(2) ：求e^2次方
Math.log(x) <== 默认是以“e”为底，而不是“2”为底

//============== throw new IllegalArgumentException() ==============
public void test(double in) {
	if (in < 0.0 || in > 1.0) {
		throw new IllegalArgumentException("input data must be between 0.0 and 1.0.");
	}
	// 。。。其它代码写在这里。。。}

//============== 抽象类和接口 ==============
Java 抽象类“abstract class” 继承接口，不用必须实现“接口的函数”，但是抽象类的子类必须实现“接口的函数”


/***************************************************************************************************
*****************************************Java字符串操作总结*****************************************
***************************************************************************************************/
//============== String.replaceAll() 正则表达式 ==============
String str = "today's ! ss ? f r, tyu. ()@#$%^&*";
String str1 = str.replaceAll("[\\pP\\p{Punct},]", ""); //去标点符号
System.out.println(str1);
输出："todays  ss  f r tyu "

//下面的语句表示先去标点，再把string按空格分成子字符串
String[] str = string.replaceAll("[\\pP\\p{Punct},]", "").split("\\s+");
String[] str = string.split("\\s+");

//============== java中的 replace 函数的重要应用 ==============
String b = "2016-03-23_13:52:23";
b = b.replace("-","");
b = b.replace(":","");
b = b.replace("_","");
System.out.println("replace output: " + b); //最后输出是: 20160323135223

/** Remove the specified symbols in the input string. 
 *  For example: String inputStr = "2016-03-23_13:52:23";
 *  For example: String[] symbols = {"-","_",":"},;
 * */
public static String removeSymbols(String inputStr, String[] symbols) {
	for(int i = 0; i < symbols.length; i++)
		inputStr = inputStr.replace(symbols[i], "");
	return inputStr;}

//============== Java获取后n位字符串 ==============
int n=3; //这边是后3位字符
String b=aa.substring(aa.length()-n, aa.length());

String a = "hello";
a.substring(0, 3);	//提取前3个字母"hel", 注意：0是提前的一个位置，不具备所需字符

//============== java字符串中只提取数字 ==============
String a="love23next234csdn3423javaeye";
String regEx="[^0-9]";
Pattern p = Pattern.compile(regEx);
Matcher m = p.matcher(a);
System.out.println( m.replaceAll("").trim());
// output: 232343423

trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾的空格都被删除了
String s=" abc ";
String s2=s.trim();  >>> 结果是s2="abc"

//============== java的字符串为 null 和 "" 时的长度区别==============
String a = "";
System.out.println( a.length() );  >>> 返回0，正确
String b = null;
System.out.println( b.length() );  >>>　报错：java.lang.NullPointerException

Java Swing的 textField文本框 返回的是空串""，不是null。(假设在不输入任何内容的情况下)

//============== java的contains()函数不区分大小写的方法==============
"ABCDEFGHIJKLMNOP".toLowerCase().contains("gHi".toLowerCase());
str1.toLowerCase().contains(str2.toLowerCase()); 		//把比较双方都转换成小写
或者 str1.toUpperCase().contains(str2.toUpperCase());	//把比较双方都转换成大写

//============== JAVA中 StringBuffer 清空  ==============
StringBuffer sb = new StringBuffer();
sb.append("aaaa");
sb.delete(0,sb.length());	//StringBuffer清空
System.out.println(sb.toString());	//显示

//===========Java字符串操作：StringBuilder(), charAt(), indexOf(c), contains(c)===========
//如果程序对附加字符串的需求很频繁，不建议使用"+"来进行字符串的串联,可考虑用java.lang.StringBuilder类
//StringBuilder StrBuilder = new StringBuilder("Hello World!"); //可以初始化"Hello World!"
StringBuilder newString = new StringBuilder();
newString.append('s'); newString.append('z'); newString.append('m');
System.out.println(newString.toString()); //newString.toString()

char c = newString.charAt(i); //获得newString的第i个位置的字符
int position = newString.indexOf(c); 	// position = -1(表示找不到) or 位置index；返回第一次出现子字符串的字符位置
boolean result = newString.contains(c); // result = true or false

//============toCharArray():把String分割每一个字符，返回char[]============
String str = "test";
char[] charArray = str.toCharArray();	//把String变成CharArray
for(int i=0; i<charArray.length; i++)	//显示每一个字符
	System.out.println(charArray[i]);
		
//============字符串比较: equalsIgnoreCase() 和 equals()============
// 相等就返回true,否则返回false
if("wd".equalsIgnoreCase(str1)) {}, 	//string是否相等的对比，忽略大小写
if("wd".equals(str1)) {}, 			//string是否相等的对比，大小写敏感

//===========================字符串的有用操作"indexOf and split"=============================
List<User> list1 = new ArrayList<User>();
if (str.indexOf("test") == -1)		//str中搜索子字符串"test"，如果返回-1表示没有搜索到，否则返回索引值
	System.out.println("返回-1表示没有搜索到，否则返回索引值");
String[] str1 = str.split(",");		//按逗号分成几段，str1[0]是第一段字符串
String str1[]=str.split("\\s+"); // "\\s+" denotes it can split many blanks，根据空格，无论多少空格，分成很多部分

//==========输入一串字符串，按空格split，最后转换成int存入数组==========
System.out.println("Please input a list of data from your keyboard:");
Scanner sc=new Scanner(System.in);
String inputString=sc.nextLine(); //input a line of string
String strArr[]=inputString.split("\\s+"); // "\\s+" denotes it can split many blanks，根据空格，无论多少空格，分成很多部分
//System.out.println(strArr.length);

int arr[]=new int[strArr.length];
for(int i=0;i<strArr.length;i++)
	arr[i]=Integer.parseInt(strArr[i]); // transfer char to int
sc.close();

//===========================indexOf and split=============================
public List<User> usersByDomain(String domain) throws Exception 
{
	String domain_in = "@"+ domain;
	List<User> list1 = new ArrayList<User>();
	String[] data1 = reader.read(1, "users.txt");
	for(int i=0; i<data1.length; i++){
		if(data1[i].indexOf(domain_in)!=-1) //indexOf查找“domain”，找不到返回-1
		{
			String[] str1 = data1[i].split(","); //根据逗号，分成很多部分		
			list1.add(new User(str1[1], str1[2]));
		}
	}
	return list1;}
/***************************************************************************************************
*****************************************Java字符串总结结束*****************************************
***************************************************************************************************/
//==========================Random来产生随机数=========================
在java.util这个包里面提供了一个Random的类，可以新建一个Random的对象来产生随机数
int max=20;
int min=10;
Random random = new Random();
int s = random.nextInt(max)%(max-min+1) + min;

//======================Java实用类型转换======================
int IntType = Integer.parseInt(StringType);		//把String变成Int
String StringType = Integer.toString(IntType);	//把Int变成String
String str = IntType + "";		//把Int变成String，只需添加一个""
String str += IntType + "";		//很关键，很常用，把str累加
String str = str + IntType + "";

//======================Java的Logger调试输出======================
private static Logger logger = Logger.getLogger(WriteCommand.class);
logger.debug("Start to write ...");

//======================Java类的静态方法使用======================
Java类的静态方法可以被任何类随意调用，比如writeData是在FileUtil类中的静态方法(public static)
FileUtil.writeData(name, buffer);	//只需import FileUtil所在的package

//======================Java实用类型转换======================
class test{
	test(){...}}
Java构造函数test()在新建对象new test()时会被调用

//======================Java数组的初始化方式及其内存分配======================
1. 静态初始化：初始化时由程序员显式指定每个数组元素的初始值，由系统决定数组长度，如：
String s = new String("absdder");
//只是指定初始值，并没有指定数组的长度，但是系统为自动决定该数组的长度为4
String[] computers = {"Dell", "Lenovo", "Apple", "Acer"};

2. 动态初始化：初始化时由程序员显示的指定数组的长度，由系统为数据每个元素分配初始值，如：
//只是指定了数组的长度，并没有显示的为数组指定初始值，但是系统会默认给数组元素分配初始值为null
String[] cars = new String[4];

//======================Java数组重要注意事项！！！！！！======================
Subset[] subsets = new Subset[10];	//动态初始化，只是在堆内存中分配了10个null指针，并没有分配实际内存
for (int i = 0; i < subsets.length; i++)
{
	subsets[i] = new Subset();	//注意！！！使用前必须分配一块内存空间，把指针subsets[i]指向“new Subset()”
	subsets[i].Parent = i;
	subsets[i].Rank = 0;}
//请注意，下面两者的区别：
Subset[] subsets = new Subset[10]; // 动态初始化，只是在堆内存中分配了10个null指针，并没有分配实际内存
int[] st = new int[10];	//在堆内存中分配了10个为0的int数据，不是null数据

					
//======================List<ArrayList<String>>的使用，important！！！======================
	//ArrayList二维数组的使用
	List<List<String>> StrList = new ArrayList<List<String>>();
	//或者 List<ArrayList<String>> StrList = new ArrayList<ArrayList<String>>();
	
	StrList.add(new ArrayList<String>()); //一定需要先添加所需数量的数组对象
	StrList.add(new ArrayList<String>()); 
	StrList.get(0).add("LoanID");		//第一个数组添加
	StrList.get(1).add("newFineAmt");	//第二个数组添加
	
String[][] data = new String[4][]; 	// 二维数组定义
int[][] data = new int[4][]; 
int[] st = new int[SIZE];   		// make array

// 注意：Vertex[10]只是对内存的10个null指针，使用前需要new，比如： vex[0] = new Vertex(), 千万记住！！！
Vertex[] vex = new Vertex[10];	//对象数组，只有null指针，必须new相应的空间
// 在类中，数组的使用必须是以下的形式，
class StackX
{
	private final int SIZE = 20;
	private int[] st; //申明数组，在析构函数中分配内存
	public StackX()           // constructor
	{
		st = new int[SIZE];   // 必须在constructor中分配内存
		for (int i = 0; i < vex.length; i++) {
			vex[i] = new Vertex(); //堆内存中只分配了null指针，并没有实际new对象，vex[i]是指针，不是对象！！！
			//......
		}	
		//......
	}
	//......}

//============Java PriorityQueue(堆heap)和 Comparator的使用============
// PriorityQueue内部做比较时，会先通过comparator进行比较；如果没有提供comparator，那么会根据元素的自然顺序进行比较。
// PriorityQueue是个基于优先级堆的极大优先级队列
// 此实现不是同步的，不是线程安全的，可以使用线程安全的PriorityBlockingQueue类
// 此实现为插入方法（poll()、remove() 、peak()、add()和offer()方法）提供 O(log(n))时间
// 该队列是用数组实现，但是数组大小可以动态增加，容量无限
public interface Comparable<T> { public int compareTo(T o); }
PriorityQueue(int initialCapacity) //使用指定的初始容量创建一个PriorityQueue，使用默认的初始容量（11）

Queue<Integer> qi = new PriorityQueue<Integer>();
qi.add(5); qi.add(9); //对于基本类型如Integer等，可以直接插入；但是对于对象，则需要通过比较器Comparator

//=======Integer也可以通过比较器=======
Comparator<Integer> cmp;
cmp = new Comparator<Integer>() { 
	public int compare(Integer e1, Integer e2) {
		return e2 - e1;
	}};
Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
q2.add(2); //q2.offer(2);
q2.add(8); //q2.offer(8);
q2.add(9); //q2.offer(9);
q2.add(1); //q2.offer(1);
while (!q2.isEmpty()) {
	System.out.print(q2.poll() + ",");}

//=======对于对象，则一定需要通过比较器Comparator=======
// 指定PriorityQueue的初始大小10，我一般倾向于不初始化，
PriorityQueue<MyThread> q = new PriorityQueue<MyThread>(10, new Comparator<MyThread>() {
    public int compare(MyThread o1, MyThread o2) {
        return o1.weight - o2.weight;
    }});
q.offer(new MyThread(5));
q.offer(new MyThread(7));
q.offer(new MyThread(2));
System.out.println(Arrays.toString(q.toArray()));

//==========================Java快速排序，效果跟PriorityQueue类似==========================
import java.util.*; //这句话重要
/*Note: 下面的connections 必须是List类型*/
//这里把cost小的往前排
Collections.sort(connections, new Comparator<Connection>() {
	@Override
	public int compare(Connection o1, Connection o2) {
		return o1.cost - o2.cost;
	}});


//======================Stack的使用======================
Stack<Integer> s = new Stack<Integer>(); // 要放int类型时，请使用int的包装类Integer
Stack<String> s = new Stack<String>();
Stack<Character> stack = new Stack<Character>(); // JRE 1.5才包括Character！？
s.push("aa"); 			// 入栈
String str1 = s.pop(); 	// 出栈
String str2 = s.peek();	// peek at top of stack
if(s.isEmpty() == true)		// check whether it is empty
	System.out.println("it is empty!");

	
//======================ArrayList的remove()，很重要的特性======================
//因为集合的大小是动态变化的，当你删除一个元素之后，元素中的序号又重新排列，所以需要“j--”
ArrayList<String> line= new ArrayList<String>();
for (int j = 0; j < line.size(); j++)
{line.remove(j); j--;}

//======ArrayList的remove()特性详解======
List list = new ArrayList();
list.add("0");
list.add("1");
list.remove(0);
结果就是：list.get(0)的结果是“1”; 
备注：如果再一次“list.remove(0);”那么list对象就是个空。

//======================ArrayList的遍历======================
ArrayList<Integer> numList = new ArrayList<Integer>();
//......，用numList.add(x)往数组里添加数据
for(int j=0; j<numList.size(); j++)
	if(numList.get(j) < numList.get(minIndex))
		minIndex = j; //求最小值的坐标
	
//======================List和ArrayList的使用======================
	//ArrayList二维数组的使用
	//注意如果是new ArrayList<ArrayList<String>>()，就是错的，只能是ArrayList<List<String>>()
	List<List<String>> StrList = new ArrayList<List<String>>();
	
	StrList.add(new ArrayList<String>()); //一定需要先添加所需数量的数组对象
	StrList.add(new ArrayList<String>());
	StrList.get(0).add("LoanID");		//第一个数组添加
	StrList.get(1).add("newFineAmt");	//第二个数组添加
			
List List = new ArrayList();
int test1=0;
float test2 = (float) 0.001;
List.add(test1);
List.add(test2); //假如不指定List类型，可以存放不同对象
1.但是一旦指定的话，就只能存放对象Integer或者int了
List<Integer> List = new ArrayList<Integer>();

//======================ArrayList的add()和set()函数的重要区别======================
ArrayList<String> newAttriList = new ArrayList<String>();
出错>>> newAttriList.set(10, 100); //在10的位置放置值为100的整数
====注意上面语句Index范围溢出出错，因为set()函数使用前提是在位置10要已经有一块空间
所以，先用newAttriList.add(...)添加数据，再可以set()

//======================List和ArrayList的使用======================
List<Integer> List = new ArrayList<Integer>(); //指定了Integer对象
List List = new ArrayList(); //不指定对象，可以存放任意元素
List.add(1);
List.set(0,12);		//注意: set(...,...)设置某个特定的element
list.get(i);		//注意: 从list列表中获取元素要使用get(...)函数
list.remove(1);		//注意：remove后ArrayList会动态调整数组，某个i元素会被后面的数组动态覆盖
List1.clear();  	//The list will be empty after “clear()”，用List1.size()来观察发现大小已经变为0

//======================Queue的使用======================
// Queue接口与List、Set同一级别，都是继承了Collection接口。
// LinkedList实现了Queue接口。Queue接口窄化了对LinkedList的方法的访问权限
比如说：Queue<Integer> que = new LinkedList<Integer>();
下表显示了jdk1.5中的阻塞队列的操作：
remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
element  返回队列头部的元素          如果队列为空，则抛出一个NoSuchElementException异常
offer    添加一个元素并返回true      如果队列已满，则返回false
poll     移除并返问队列头部的元素    如果队列为空，则返回null
peek     返回队列头部的元素          如果队列为空，则返回null
add      增加一个元索                如果队列已满，则抛出一个IIIegaISlabEepeplian异常
put      添加一个元素                如果队列满，则阻塞
take     移除并返回队列头部的元素    如果队列为空，则阻塞

//======================LinkedList的使用======================
LinkedList<Integer> que = new LinkedList<Integer>();
// que.poll() 和 que.offer() 当属于Queue; 
if(!que.isEmpty())
{
	que.offer(199);	//offer()和add()功能一样，add当属于List，offer当属于queue
	int i = que.poll(); //移除并返回第一个数据，关键是存在移除动作
	
	que.add(199); 	//如果不指定索引的话，元素将被添加到链表的最后
	
	que.removeFirst();	//跟poll()的作用类似
	que.removeLast();
	
	//也可以把链表当初栈或者队列来处理
	que.addFirst(299);
	que.addLast(399); //addLast()方法和不带索引的add()方法实现的效果一样}

//将LinkedList转换成ArrayList
ArrayList<String> arrayList = new ArrayList<String>(linkedList); 

//使用链表来实现队列效果
class Queue {  
  private LinkedList list = new LinkedList();  
  public void put(Object v) {  
    list.addFirst(v);  
  }
  public Object get() {  
    return list.removeLast();  
  }
  public boolean isEmpty() {  
    return list.isEmpty();
  }} 

//同步方法
LinkedList queue = new LinkedList(); 
queue = (LinkedList) Collections.synchronizedList(queue);
//======================HashMap======================
// HashMap<String , Double> map = new HashMap<String , Double>();   
// map.put("语文" , 80.0);
HashMap<String, String> hashMap = new HashMap<String, String>();  
hashMap.put("cn", "中国");
hashMap.put("jp", "日本");
hashMap.put("fr", "法国");
  
System.out.println(hashMap); 	//输出: {jp=日本, cn=中国, fr=法国},
System.out.println("cn:" + hashMap.get("cn"));	//输出: cn:中国
System.out.println(hashMap.containsKey("cn"));	//输出: true
System.out.println(hashMap.keySet());	//输出: [jp, cn, fr] 	
System.out.println(hashMap.isEmpty());	//输出: false
  
hashMap.remove("cn");
System.out.println(hashMap.containsKey("cn"));	//输出: false

//=============hashMap最经典的一种遍历=============
for (String key : map.keySet()){
	//value = map.get(key)}
//=============hashMap第二种遍历方法：采用Iterator遍历HashMap=============
Iterator it = hashMap.keySet().iterator();  
while(it.hasNext()) {  
	String key = (String)it.next();  
	System.out.println("key:" + key);  
	System.out.println("value:" + hashMap.get(key));  }

//============List 和 HashMap 结合的经典用法(附带Scanner的经典输入法)============
//定义保存学生信息的List，元素类型为HashMap  
List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
Scanner input = new Scanner(System.in);  
  
System.out.println("请输入学生的信息,y表示继续，n表示退出");  
while("y".equals(input.next())) {  
	HashMap<String, Object> map = new HashMap<String, Object>();  
	System.out.println("请输入学号");  
	map.put("studentno", input.next());	// next()是默认输入String类型
	System.out.println("请输入姓名");
	map.put("name", input.next());  	// next()是默认输入String类型
	System.out.println("请输入年龄");  
	map.put("age", input.nextInt());	// nextInt()表示输入整型，nextFloat()是float类型
	list.add(map);  
	System.out.println("请继续输入学生的信息,y表示继续，n表示退出");  }   
System.out.println("学生数量为:" + list.size());
Iterator<HashMap<String, Object>> it = list.iterator();
int i = 1;
while(it.hasNext()) {
	HashMap<String, Object> stuMap = it.next();  
	System.out.print("第" + i + "个学生的信息为");  
	System.out.println("学号:" + stuMap.get("studentno") + " ,姓名:" + stuMap.get("name") + " ,年龄:" + stuMap.get("age"));
	i++; //???}

/** ==========================Java泛型：Comparable<T>============================*/
先了解一下：Comparable是公共接口
public interface Comparable { public boolean compareTo(T other); }

/** 
 * <T extends Comparable>这种形式非常重要！！！，compareTo方法是来自Comparable的
 * a > b 是a.compareTo(b) > 0, 
 * a = b 是a.compareTo(b) == 0, 
 * a < b 是a.compareTo(b) < 0
 * */
class compare<T extends Comparable>
{	
	/*T cmp1; T cmp2;
	public compare(T cmp1, T cmp2){ //析构函数
	  this.cmp1 = cmp1; this.cmp2 = cmp2;
	},*/
	public T max(T t1, T t2) { 
		if (t1.compareTo(t2) > 0)
			return t1;
		else 
			return t2;
	}
	/*//可以对Comparable的接口函数compareTo进行重写，实现不同功能
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}*/}
在main()主函数中进行测试：
int m1 = 0; int m2 = 5;
compare<Integer> test1 = new compare(); //注意类型声明为<Integer>
System.out.println(test1.max(m1, m2));
>> 输出：5

float mm1 = (float) 9.9; float mm2 = (float) 8.8;
compare<Float> test2 = new compare();	//注意类型声明为<Float>
System.out.println(test2.max(mm1, mm2));
>> 输出：9.9







/*===============================简易模板： java STDIN输入=============================*/
import java.util.*;
import java.io.*;
class beads
{
    public static void main(String[] args) throws Exception
	{
		/*=============Java STDIN=============
        //Scanner input = new Scanner(new File("beads.in")); //从文件中读入
		Scanner input = new Scanner(System.in);		//窗口中读入
		String inputString = input.nextLine(); 		//input a line of string
		String str[]=inputString.split("\\s+");		//"\\s+" denotes 根据空格，无论多少空格，分成很多部分
		*/
		//=============Java STDIN： 第二种标准方法=============
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
        try { 
        	inputString = stdin.readLine();	
        },catch (IOException ex){ 
        	System.out.println(ex); 
        }, 	
        //String inputString1 = stdin.readLine(); // <<<<<< 或者直接输入1
        //String inputString2 = stdin.readLine(); // <<<<<< 或者直接输入2	
		
		//=============Java STDOUT=============
		System.out.println(inputString);
        //PrintWriter output = new PrintWriter("beads.out");
		//...
        //output.close();
	}}

/*===============================简易模板： java STDIN循环输入多行=============================*/
public static void main(String[] args) throws IOException {
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
	String line; 

	while ((line = stdin.readLine()) != null && line.length()!= 0) { 
		String[] input = line.split(" "); // or "\\s+"
		if (input.length == 2) { 
			System.out.println(calculateAnswer(input[0], input[1])); 
		}
	}}
	
//=========================================================
1.最常用的方法。循环找出该位子的list元素
for(int i = 0;i < list.size(); i++){
	System.out.println(list.get(i));}
2.利用Iterator 类和while方法
Iterator it1 = list.iterator();
while(it1.hasNext()){
	System.out.println(it1.next());}
3.利用Iterator 类和for循环(和第2种方法相似)
for(Iterator it2 = list.iterator();it2.hasNext();){
	System.out.println(it2.next());}
4.最简单的方法
for(String tmp:list){
	System.out.println(tmp);}

/////////////////////////////StackX实现的内部代码//////////////////////////////
class StackX
{
	private final int SIZE = 20;
	private int[] st; //申明数组，在析构函数中分配内存
	private int top;

	public StackX()           // constructor
	{
		st = new int[SIZE];   // make array
		top = -1;	//注意初始化为-1
	},
	public void push(int j)   // put item on stack
	{ st[++top] = j; }
	
	public int pop()          // take item off stack
	{ return st[top--]; }

	public int peek()         // peek at top of stack
	{ return st[top]; }

	public boolean isEmpty()  // true if nothing on stack-
	{ return (top == -1); }
}/**/

//==============================Java的Socket详解===============================
// private InetAddress address;	//两者的address类型都是InetAddress
byte byteAddr[] = { 127, 0, 0, 1 };
int port = 10023;
InetAddress address = InetAddress.getByAddress(byteAddr);
//============Socket客户端第一种连接方式============
Socket socket = new Socket();
SocketAddress saddr = new InetSocketAddress(address, port);
socket.connect(saddr);
//============Socket客户端第二种连接方式============
Socket socket = null;
socket = new Socket(address.getHostAddress(), port);

OutputStream outStream = socket.getOutputStream();	//向outStream写数据，表示发送数据到外面
InputStream inputStream = socket.getInputStream();	//从inputStream读数据，它来自外部
//期间，进行socket的读写操作......
inputStream.close();	//一般先把inputStream输入流关闭
socket.close(); 		//再关闭socket

//================Java单例模式(singleton pattern)================
public class Batch
{
	private Map<String, Command> commands;
	
	private static class BatchInstance 
	{ private static final Batch instance = new Batch();}
	
	public static Batch getInstance() //注意这边是static，可以被Batch.getInstance()
	{ return BatchInstance.instance; }
	
	private Batch() //注意构造器的类型是"private"，而不是惯用的public
	{/*...*/}	//只有在第一次调用Batch.getInstance()的时候，才使用一次构造函数？？？
	
	public void addCommand(Command command){/*...*/}
	public Map<String, Command> getCommands() {return commands;}}
//其他任意文件中可以操作这个单例
Batch bat = Batch.getInstance(); //important: obtain instance of Batch
bat.addCommand(cmd);
Map<String, Command> map = bat.getCommands();


//==========================二叉树拷贝方法=========================
public class Node implements Cloneable
{
	//instance variables
	private String name; 
	private int value;
	private Node left;
	private Node right;
	private int x;
	
	protected Object clone() 
	{    
		try {
			Node BtreeClone1 = (Node) super.clone();
			if (this.left != null)
				BtreeClone1.left = (Node)this.left.clone();
			if (this.right != null)
				BtreeClone1.right = (Node) this.right.clone();
			return BtreeClone1; //return deep copy
		}
		catch(CloneNotSupportedException e){
			//can not happen-- we support clone here
			throw new InternalError(e.toString());
		}
	}}
怎么拷贝：
Node rootNew = (Node)root.clone(); //拷贝现存的二叉树，从root根节点入手

//==========================SZM:修改后的多叉树拷贝=========================
class Node implements Cloneable
{	
	public String attribute; 	
	public String arrived_value;
    ArrayList<Node> childs = new ArrayList<Node>();	//子结点集合，注意它是多叉树
    Node() {
    	attribute = null;
    	arrived_value = null;
    	//childs = new ArrayList<Node>();
    }
	protected Object clone() //拷贝多叉树
	{
		try {
			Node treeClone = (Node)super.clone();
			//下面这条语句非常比较，相当于为新克隆的treeClone的childs拷贝了一块内存；不然会出错！！！
			treeClone.childs = (ArrayList<Node>) this.childs.clone(); 

			for(int i=0; i<this.childs.size(); i++) {
				if(this.childs.get(i) != null)
					treeClone.childs.set(i, (Node)this.childs.get(i).clone());
			}
			return treeClone;
		}
		catch(CloneNotSupportedException e){
			throw new InternalError(e.toString()); //can not happen-- we support clone here
		}
	}}
怎么拷贝：
Node rootNew = (Node)root.clone(); //拷贝现存的二叉树，从root根节点入手

//=======================Java 创建文件夹和目录=======================
	try{
		/*查找目录，如果不存在，就创建*/
		File dirFile = new File("e:/test");
		if(!dirFile.exists()){
			if(!dirFile.mkdir())
				throw new Exception("目录不存在，创建失败！");
		}
		/*查找文件，如果不存在，就创建*/
		File file = new File("e:/test/text1.txt");
		if(!file.exists())
			if(!file.createNewFile())
				throw new Exception("文件不存在，创建失败！");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}

/** ################### 泛型T的泛型化Comparable使用 ###################
 * <T extends Comparable>这种形式非常重要！！！，compareTo方法是来自Comparable的
 * a > b 是a.compareTo(b) > 0, 
 * a = b 是a.compareTo(b) == 0, 
 * a < b 是a.compareTo(b) < 0 
 * */
class compare<T extends Comparable>
{	
	public boolean compareTwoNum(T t1, T t2, String operator) {
		if(operator.equals(">"))
		{
			if (t1.compareTo(t2) > 0) // t1 > t2
				return true;
			else 
				return false;
		}
		else if(operator.equals("="))
		{
			if( t1.compareTo(t2) == 0) // t1 = t2
				return true;
			else 
				return false;				
		}
		else if(operator.equals("<"))
		{
			if( t1.compareTo(t2) < 0) // t1 < t2
				return true;
			else 
				return false;				
		}
		else
			return false;
	}}
实际中如下使用>>>>
compare<String> cmp = new compare();
boolean result = cmp.compareTwoNum(m1, m2, operator); //true or false


/** ############################# FileOutputStream #############################*/
//===================获得一个文件夹中的所有文件名===================
File file=new File("D:\\");
String test[];
test=file.list();
for(int i=0;i<test.length;i++)
{
	System.out.println(test[i]);}

//===================该类用来创建一个文件并向文件中写数据===================
File f = new File("a.txt");
// 构建FileOutputStream对象,文件不存在会自动新建
FileOutputStream fop = new FileOutputStream(f);
// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

writer.append("中文输入"); 	// 写入到缓冲区
writer.append("\r, "); 		// 换行
writer.append("English"); 	// 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

//千万注意：writer和fop有顺序
writer.close();				// 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
fop.close(); 				// 关闭输出流,释放系统资源

//===================向文件中读取数据：StringBuffer读取的是一个字符===================
File f = new File("a.txt");
// 构建FileInputStream对象
FileInputStream fip = new FileInputStream(f);
// 构建InputStreamReader对象,编码与写入相同
InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
// 转成char加到StringBuffer对象中
StringBuffer sb = new StringBuffer();
while (reader.ready()) {
	sb.append((char) reader.read());}
System.out.println(sb.toString());
reader.close(); // 关闭读取流
fip.close(); // 关闭输入流,释放系统资源

//===================向文件中读取数据：BufferedReader读取的是一个字符===================
try {
	File file = new File("a.txt");
	FileInputStream fi = new FileInputStream(file);
	InputStreamReader ir = new InputStreamReader(fi);
	BufferedReader br = new BufferedReader(ir);
	
	String str = br.readLine().trim();	//读取一行
	//char chr = (char) br.read();	//读取一个字符 <====这个经测试读取的字符比较乱！！！
	
	String tmp = br.readLine().trim();
	for(int j=0; j<tmp.length(); j++)
	{
		data[j] = Integer.parseInt(String.valueOf(tmp.charAt(j))); //把字符char转换成int
		System.out.print(data[j]);
	}
	
	fi.close();
	ir.close();
	br.close();} catch (IOException e) {
	e.printStackTrace();}

//===================================================================
//============================Java Thread============================
//===================================================================
Java Thread Benefits:
1. Java Threads are lightweight compared to processes, it takes less time and resource to create a thread.
2. Threads share their parent process data and code
3. Context switching between threads is usually less expensive than between processes.
4. Thread intercommunication is relatively easy than process communication.

<1> Implementing the java.lang.Runnable interface.
<2> Extending the java.lang.Thread class.

互斥锁（关键字synchronized）:
b.Java对象默认是可以被多个线程共用的，只是在需要时才启动“互斥锁”机制，成为专用对象。
c.关键字synchronized用来与对象的互斥锁联系
d.当某个对象用synchronized修饰时，表明该对象已启动“互斥锁”机制，在任一时刻只能由一个线程访问，
即使该线程出现堵塞，该对象的被锁定状态也不会解除，其他线程任不能访问该对象

Java常用方法:
static void sleep(long t) //释放CPU的执行权，不释放锁
final void wait() 	//释放CPU的执行权，释放锁
final void notify()	//
static void yield() //可以对当前线程进行临时暂停（让线程将资源释放出来）
public final void join() //当前执行join方法的线程会被冻结，等待当前线程执行结束，或者join(2000)
isAlive()

//===========================================================
结束线程的方法(就是让run方法结束)：
1. run方法中通常会定义循环结构，所以只要控制住循环即可
2. 可以boolean标记的形式完成，只要在某一情况下将标记改变，让循环停止即可让线程结束
3. 执行另外一线程的join()，当另外线程结束的时候，该线程才会恢复到可运行状态? 或 结束？
private volatile boolean done = false; //使用了volatile关键字，它主要是为了同步???
public void setDone(){	//调用方法setDone()去结束线程
	done = true;}
public void run() {
	while(!done){
		//...task...
		try {Thread.sleep(1000);}, catch (InterruptedException ie) {return;},
	}}

//=========================Runnable的优点=========================
//Runnable的优点：http://www.oschina.net/question/565065_86563
在程序开发中只要是多线程肯定永远以实现Runnable接口为主，因为实现Runnable接口
//使用Runnable定义的子类中没有start()方法，只有Thread类中才有，
//public Thread(Runnable targer)此构造方法接受Runnable的子类实例
public interface Runnable{
public void run();}
//一种使用方式：
Thread thread = new Thread(new Runnable(){
       @Override
       public void run(){
          ...
       }});
thread.start();

Runnable的优点：
1. 避免点继承的局限，一个类可以继承多个接口。
2. 适合于资源的共享(见下面火车票的例子)

Runnable接口和Thread之间的联系：
public class Thread extends Object implements Runnable //发现Thread类也是Runnable接口的子类

//====================Runnable和Thread重要区别(资源共享)======================
// Runnable接口一共卖了10张票，也就是说使用Runnable实现多线程可以达到资源共享目的。
// 但是Thread类每个线程都各卖了10张，共卖了20张票，每个线程都卖自己的票，没有达到资源共享
public static void main(String[] args) {
	//====================Runnable接口启动====================
	//====第一种形式====
	Thread t1 = new Thread(new MyRunnable(), "t1");
	//Thread t2 = new Thread(new MyRunnable(), "t2");
	t1.start();	//很关键，启动两个线程，但共享MyRunnable类中的资源
	t1.start();
	//====第二种形式====
	//MyRunnable t1 = new MyRunnable();
	//new Thread(t1).start(); //功能同上
	//new Thread(t1).start();
	
	t1.join();	//同步等待，直到t1线程结束
	
	//====================Thread启动====================
	MyThread mt1=new MyThread("线程a");
	MyThread mt2=new MyThread("线程b");
	mt1.start();	//劣势，启动两个线程，但不能共享MyThread类中的资源
	mt2.start();
	
	//mt1.start(); mt1.start(); //虽然连续启动两次，但是实际只是第一次有效}
class MyRunnable implements Runnable{ //Runnable接口方式
	private int ticket=10;
	@Override	
	public void run(){  
		for(int i=0;i<20;i++){
			if(this.ticket>0)
				System.out.println("卖票：ticket"+this.ticket--);  
		}
	}}
class MyThread extends Thread{ //Thread类方式
	private int ticket=10;
	@Override	
	public void run(){  
		for(int i=0;i<20;i++){
			if(this.ticket>0)
				System.out.println("卖票：ticket"+this.ticket--);  
		}
	}}

















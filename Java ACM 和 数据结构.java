
//========================================================================================
//====================================Java����֪ʶ�ܽ�====================================
//========================================================================================
���������(reference)��ϵ��Thermostat therm1 = new Thermostat(); // new��java�з���һ������
Java�Ի�����������(byte��int��short��long��boolean��char��float��double)�Ĵ��������Ĵ���ͬ��
int test;			//һ�������ݿռ��ֵ
Thermostat therm1;	//Java�д���һ��Ϊnull������; Ȼ����C++�У�������һ�������������ݿռ�
therm1 = therm2;	//Java��ֻ�ǿ����洢��ַ������C++�У�therm2������������ݿ�����therm1������
if(therm1 == therm2);	//Java���жϵ��������Ƿ�ָ��ͬһ�����󣬵���C++�У��ж����������Ƿ���ͬ������
Java�У�һ��int��Զ��32λ������C��C++�У�int��Сȡ�������еļ������
Java�У�float��long������Ҫ�Ӻ�׺�����磺3.14159F��4567774L

��C++��ͬ���ǣ�Java�����鵱�������Դ�������ڴ�������ʱ����ʹ��new�����磺
int[] intArray; intArray = new int[100]; //������һ��length�ֶΣ���֪����ǰ�����С
autoData test = new autoData[100];
һ�ֳ�ʼ������(ʡ����new)��int[] intArray = {0, 1, 2, 3};

Java�����ַ�����C��C++�鷳��
public static String getString() throws IOException
{
	InputStreamReader isr = new InputStreamReader(System.in); //ͨ���س���ֹ
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;}
String s = getString();
s.charAt(0);			//��ȡString�ĵ�һ��Ԫ��
String s = getString();
Integer.parseInt(s);	//��Stringת����int����

//For float and double, the conversion process is more complex.
String s = getString();
Double aDub = Double.valueOf(s);//��Stringת����Double����
aDub.doubleValue();
Float aFlo = Float.valueOf(s);	//��Stringת����Float����
aFlo.floatValue();

final�ؼ���ʹ��:
final class can't be inherited; 
final method can't be overridden; 
final variable value can't be changed.

Collection
��List
����LinkedList
����ArrayList
����Vector
������Stack
��Set
Java���ݽṹ�ܽ᣺
����漰����ջ�����еȲ�����Ӧ�ÿ�����List(������LinkedList��ArrayList)��
������Ҫ���ٲ��룬ɾ��Ԫ�أ�Ӧ��ʹ��LinkedList��
�����Ҫ�����������Ԫ�أ�Ӧ��ʹ��ArrayList��

## HashMap vs. TreeMap vs. HashTable vs. LinkedHashMap
+ Overview
  - HashMap: implemented as a hash table, no ordering on keys or values
  - TreeMap: implemented based on red-black tree, ordered by key
  - LinkedHashMap: preserves insertion order
  - HashTable: synchronized in constrast to HashMap
  
//==========Java STDIN and STDOUT ģ��==========
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))
String inStr1 = stdin.readLine();
String inStr2 = stdin.readLine();
System.out.println(...);
System.out.println(...);

//========================================================================================

//======================Java�����������ֵ����Сֵ======================
Java���ṩ��long��int��short����byte�����������͵����ֵ����Сֵ�Ĵ��롣
���ֵ��������ΪMAX_VALUE����Сֵ����ΪMIN_VALUE����ʹ��ʱ�ֱ�������������ˡ�
��MAX_VALUEΪ����
java.lang.Long.MAX_VALUE 	(9223372036854775807 ~ -9223372036854775808)
java.lang.Integer.MAX_VALUE	(2147483647 ~ -2147483648)
java.lang.Short.MAX_VALUE	(32767 ~ -32768)
java.lang.byte.MAX_VALUE	(127 ~ -128)
java.lang.Integer.MIN_VALUE

//======================Java��������======================
�����������ͣ�byte��int��short��long��boolean��char��float��double��
Wrapper���ͣ�
Byte��Integer��Short��Long��Boolean��Character��Float��Double��

//===================java������sum +=i��sum=+i===================
sum += i;  	//�൱�� sum = sum + i
sum = +i; 	//�൱��sum = i����������൱��һ����ֵ�ˣ����������໥���ٸ�ֵ

//======================LinkedList �� ArrayList��Ҫ����======================
LinkedList�ӿ� �ڴ����ʹ�ù����к�ArrayListû��ʲô����
ArrayList�ײ���object���飬����ArrayList��������Ĳ�ѯ�ٶȿ���ŵ��Լ���ɾ�ٶ�����ȱ�㡣
����LinkedList�ĵײ���һ��˫��ѭ�������ڴ�������ÿһ�����ݽڵ㶼����������ɣ�
ǰָ��(ָ��ǰ��Ľڵ��λ��)�����ݣ���ָ��(ָ�����Ľڵ��λ��)��
���һ���ڵ�ĺ�ָ��ָ���һ���ڵ��ǰָ�룬�γ�һ��ѭ���� 
˫��ѭ������Ĳ�ѯЧ�ʵ͵�����ɾЧ�ʸߡ�����LinkedList���в�ѯЧ�ʵ͵���ɾЧ�ʸߵ��ص㡣
ArrayList��LinkedList���÷���û�����𣬵����ڹ����ϻ���������ġ�

LinkedList����������ɾ�����϶����ѯ�������ٵ�����£����кͶ�ջ��
���У��Ƚ��ȳ������ݽṹ��
��ջ������ȳ������ݽṹ��
ע��ʹ�ö�ջ��ʱ��һ�������ṩ�����ò������һ��Ԫ�ص�Ԫ�ػ�ó�ջ�Ļ��ᡣ
LinkedList�ṩ���·�����(ArrayList�ޱ��෽��)
addFirst(); 
removeFirst();
addLast();
removeLast();

�ڶ�ջ�У�pushΪ��ջ������popΪ��ջ������
Push��addFirst()��pop��removeFirst()��ʵ�ֺ���ȳ���
��isEmpty()--�丸��ķ��������ж�ջ�Ƿ�Ϊ�ա�
 
�ڶ����У�putΪ����в�����getΪ�����в�����
Put��addFirst()��get��removeLast()ʵ�ֶ��С�

//======================Java StringTokenizerʹ�þ���======================
StringTokenizer st = new StringTokenizer("this is test");
while (st.hasMoreTokens())
	{System.out.println(st.nextToken());}
��ӡ����֮���ǣ�
this
is
test
//==========Ч����ʹ��splitһ��==========
String[] result = "this is test".split("\\s"); //����"\\t" ???
for (int x=0; x<result.length; x++)
	System.out.println(result[x]);

//=============������������飬hashmap���������ͳ���ַ������ֵĴ���=============
��hashmap�У�keyΪ���ַ�������valueΪ���ַ������ִ�������
����ַ����Ѵ��ڣ�����Ϊ���ַ�����ֵ��1��������Ӽ�ֵ�� ���ַ�����>���ִ���1��
if (map.containsKey(str)) { 
	map.put(str, map.get(str) + 1);} else { 
	map.put(str, 1); //�˴�Ӧ����1�ɣ���ʾ����1�Σ�0Ҳ���ԣ�}

//============== Java ��������ת�� ==============
1d -- ��ʾ����double����
3.14f -- ��ʾ����float����
7778889933l -- 'l'��ʾ����long����

//============== ������������ʵ��"����ͬ������������ͬ" ==============
/**��forward()�ڲ���������������ʽ��forward(input, hidden, iptHidWeights)*/
private void forward() {
	forward(input, hidden, iptHidWeights);	//���������У�ĳ���õ������
	forward(hidden, output, hidOptWeights);}
private void forward(double[] layer0, double[] layer1, double[][] weight) {
	//......}

//============== �����ж���� ==============
// log2(x) = log(x) / log(2), and x could not be zero
public static double log2(double x) {
	 return x == 0 ? 0 : (Math.log(x)/Math.log(2)); //�����ж����}
  
//==============java�е�Scanner����һ��Ҫ��ĳ�����Ž���==============
>>> ���ݿ��е�Ӧ��
Scanner scanner = new Scanner(System.in).useDelimiter(";");

//============== java�е� ��ʱ���� ==============
long timeStart = System.currentTimeMillis();
//......
long timeEnd = System.currentTimeMillis();
System.out.println("The Whole time is " + (timeEnd - timeStart));
			
//============== java�е�����ȡ������ ==============
����ȡ��: Math.ceil(3.1)=4
����ȡ��: Math.floor(3.5)=3
��������ȡ��: Math.rint(3.5)=4

/** ǧ��ע�⣺Java��ƽ�������� x^2������ Math.pow(x,2) */
Math.pow(x,y) ��x��y�η�
Math.sqrt(x) ����ƽ����
Math.E = Math.exp(1) = 2.718281828459045
Math.exp(2) ����e^2�η�
Math.log(x) <== Ĭ�����ԡ�e��Ϊ�ף������ǡ�2��Ϊ��

//============== throw new IllegalArgumentException() ==============
public void test(double in) {
	if (in < 0.0 || in > 1.0) {
		throw new IllegalArgumentException("input data must be between 0.0 and 1.0.");
	}
	// ��������������д���������}

//============== ������ͽӿ� ==============
Java �����ࡰabstract class�� �̳нӿڣ����ñ���ʵ�֡��ӿڵĺ����������ǳ�������������ʵ�֡��ӿڵĺ�����


/***************************************************************************************************
*****************************************Java�ַ��������ܽ�*****************************************
***************************************************************************************************/
//============== String.replaceAll() ������ʽ ==============
String str = "today's ! ss ? f r, tyu. ()@#$%^&*";
String str1 = str.replaceAll("[\\pP\\p{Punct},]", ""); //ȥ������
System.out.println(str1);
�����"todays  ss  f r tyu "

//���������ʾ��ȥ��㣬�ٰ�string���ո�ֳ����ַ���
String[] str = string.replaceAll("[\\pP\\p{Punct},]", "").split("\\s+");
String[] str = string.split("\\s+");

//============== java�е� replace ��������ҪӦ�� ==============
String b = "2016-03-23_13:52:23";
b = b.replace("-","");
b = b.replace(":","");
b = b.replace("_","");
System.out.println("replace output: " + b); //��������: 20160323135223

/** Remove the specified symbols in the input string. 
 *  For example: String inputStr = "2016-03-23_13:52:23";
 *  For example: String[] symbols = {"-","_",":"},;
 * */
public static String removeSymbols(String inputStr, String[] symbols) {
	for(int i = 0; i < symbols.length; i++)
		inputStr = inputStr.replace(symbols[i], "");
	return inputStr;}

//============== Java��ȡ��nλ�ַ��� ==============
int n=3; //����Ǻ�3λ�ַ�
String b=aa.substring(aa.length()-n, aa.length());

String a = "hello";
a.substring(0, 3);	//��ȡǰ3����ĸ"hel", ע�⣺0����ǰ��һ��λ�ã����߱������ַ�

//============== java�ַ�����ֻ��ȡ���� ==============
String a="love23next234csdn3423javaeye";
String regEx="[^0-9]";
Pattern p = Pattern.compile(regEx);
Matcher m = p.matcher(a);
System.out.println( m.replaceAll("").trim());
// output: 232343423

trim()�������ص����ַ��������һ������������������ʼ�ͽ�β�Ŀո񶼱�ɾ����
String s=" abc ";
String s2=s.trim();  >>> �����s2="abc"

//============== java���ַ���Ϊ null �� "" ʱ�ĳ�������==============
String a = "";
System.out.println( a.length() );  >>> ����0����ȷ
String b = null;
System.out.println( b.length() );  >>>������java.lang.NullPointerException

Java Swing�� textField�ı��� ���ص��ǿմ�""������null��(�����ڲ������κ����ݵ������)

//============== java��contains()���������ִ�Сд�ķ���==============
"ABCDEFGHIJKLMNOP".toLowerCase().contains("gHi".toLowerCase());
str1.toLowerCase().contains(str2.toLowerCase()); 		//�ѱȽ�˫����ת����Сд
���� str1.toUpperCase().contains(str2.toUpperCase());	//�ѱȽ�˫����ת���ɴ�д

//============== JAVA�� StringBuffer ���  ==============
StringBuffer sb = new StringBuffer();
sb.append("aaaa");
sb.delete(0,sb.length());	//StringBuffer���
System.out.println(sb.toString());	//��ʾ

//===========Java�ַ���������StringBuilder(), charAt(), indexOf(c), contains(c)===========
//�������Ը����ַ����������Ƶ����������ʹ��"+"�������ַ����Ĵ���,�ɿ�����java.lang.StringBuilder��
//StringBuilder StrBuilder = new StringBuilder("Hello World!"); //���Գ�ʼ��"Hello World!"
StringBuilder newString = new StringBuilder();
newString.append('s'); newString.append('z'); newString.append('m');
System.out.println(newString.toString()); //newString.toString()

char c = newString.charAt(i); //���newString�ĵ�i��λ�õ��ַ�
int position = newString.indexOf(c); 	// position = -1(��ʾ�Ҳ���) or λ��index�����ص�һ�γ������ַ������ַ�λ��
boolean result = newString.contains(c); // result = true or false

//============toCharArray():��String�ָ�ÿһ���ַ�������char[]============
String str = "test";
char[] charArray = str.toCharArray();	//��String���CharArray
for(int i=0; i<charArray.length; i++)	//��ʾÿһ���ַ�
	System.out.println(charArray[i]);
		
//============�ַ����Ƚ�: equalsIgnoreCase() �� equals()============
// ��Ⱦͷ���true,���򷵻�false
if("wd".equalsIgnoreCase(str1)) {}, 	//string�Ƿ���ȵĶԱȣ����Դ�Сд
if("wd".equals(str1)) {}, 			//string�Ƿ���ȵĶԱȣ���Сд����

//===========================�ַ��������ò���"indexOf and split"=============================
List<User> list1 = new ArrayList<User>();
if (str.indexOf("test") == -1)		//str���������ַ���"test"���������-1��ʾû�������������򷵻�����ֵ
	System.out.println("����-1��ʾû�������������򷵻�����ֵ");
String[] str1 = str.split(",");		//�����ŷֳɼ��Σ�str1[0]�ǵ�һ���ַ���
String str1[]=str.split("\\s+"); // "\\s+" denotes it can split many blanks�����ݿո����۶��ٿո񣬷ֳɺܶಿ��

//==========����һ���ַ��������ո�split�����ת����int��������==========
System.out.println("Please input a list of data from your keyboard:");
Scanner sc=new Scanner(System.in);
String inputString=sc.nextLine(); //input a line of string
String strArr[]=inputString.split("\\s+"); // "\\s+" denotes it can split many blanks�����ݿո����۶��ٿո񣬷ֳɺܶಿ��
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
		if(data1[i].indexOf(domain_in)!=-1) //indexOf���ҡ�domain�����Ҳ�������-1
		{
			String[] str1 = data1[i].split(","); //���ݶ��ţ��ֳɺܶಿ��		
			list1.add(new User(str1[1], str1[2]));
		}
	}
	return list1;}
/***************************************************************************************************
*****************************************Java�ַ����ܽ����*****************************************
***************************************************************************************************/
//==========================Random�����������=========================
��java.util����������ṩ��һ��Random���࣬�����½�һ��Random�Ķ��������������
int max=20;
int min=10;
Random random = new Random();
int s = random.nextInt(max)%(max-min+1) + min;

//======================Javaʵ������ת��======================
int IntType = Integer.parseInt(StringType);		//��String���Int
String StringType = Integer.toString(IntType);	//��Int���String
String str = IntType + "";		//��Int���String��ֻ�����һ��""
String str += IntType + "";		//�ܹؼ����ܳ��ã���str�ۼ�
String str = str + IntType + "";

//======================Java��Logger�������======================
private static Logger logger = Logger.getLogger(WriteCommand.class);
logger.debug("Start to write ...");

//======================Java��ľ�̬����ʹ��======================
Java��ľ�̬�������Ա��κ���������ã�����writeData����FileUtil���еľ�̬����(public static)
FileUtil.writeData(name, buffer);	//ֻ��import FileUtil���ڵ�package

//======================Javaʵ������ת��======================
class test{
	test(){...}}
Java���캯��test()���½�����new test()ʱ�ᱻ����

//======================Java����ĳ�ʼ����ʽ�����ڴ����======================
1. ��̬��ʼ������ʼ��ʱ�ɳ���Ա��ʽָ��ÿ������Ԫ�صĳ�ʼֵ����ϵͳ�������鳤�ȣ��磺
String s = new String("absdder");
//ֻ��ָ����ʼֵ����û��ָ������ĳ��ȣ�����ϵͳΪ�Զ�����������ĳ���Ϊ4
String[] computers = {"Dell", "Lenovo", "Apple", "Acer"};

2. ��̬��ʼ������ʼ��ʱ�ɳ���Ա��ʾ��ָ������ĳ��ȣ���ϵͳΪ����ÿ��Ԫ�ط����ʼֵ���磺
//ֻ��ָ��������ĳ��ȣ���û����ʾ��Ϊ����ָ����ʼֵ������ϵͳ��Ĭ�ϸ�����Ԫ�ط����ʼֵΪnull
String[] cars = new String[4];

//======================Java������Ҫע���������������======================
Subset[] subsets = new Subset[10];	//��̬��ʼ����ֻ���ڶ��ڴ��з�����10��nullָ�룬��û�з���ʵ���ڴ�
for (int i = 0; i < subsets.length; i++)
{
	subsets[i] = new Subset();	//ע�⣡����ʹ��ǰ�������һ���ڴ�ռ䣬��ָ��subsets[i]ָ��new Subset()��
	subsets[i].Parent = i;
	subsets[i].Rank = 0;}
//��ע�⣬�������ߵ�����
Subset[] subsets = new Subset[10]; // ��̬��ʼ����ֻ���ڶ��ڴ��з�����10��nullָ�룬��û�з���ʵ���ڴ�
int[] st = new int[10];	//�ڶ��ڴ��з�����10��Ϊ0��int���ݣ�����null����

					
//======================List<ArrayList<String>>��ʹ�ã�important������======================
	//ArrayList��ά�����ʹ��
	List<List<String>> StrList = new ArrayList<List<String>>();
	//���� List<ArrayList<String>> StrList = new ArrayList<ArrayList<String>>();
	
	StrList.add(new ArrayList<String>()); //һ����Ҫ����������������������
	StrList.add(new ArrayList<String>()); 
	StrList.get(0).add("LoanID");		//��һ���������
	StrList.get(1).add("newFineAmt");	//�ڶ����������
	
String[][] data = new String[4][]; 	// ��ά���鶨��
int[][] data = new int[4][]; 
int[] st = new int[SIZE];   		// make array

// ע�⣺Vertex[10]ֻ�Ƕ��ڴ��10��nullָ�룬ʹ��ǰ��Ҫnew�����磺 vex[0] = new Vertex(), ǧ���ס������
Vertex[] vex = new Vertex[10];	//�������飬ֻ��nullָ�룬����new��Ӧ�Ŀռ�
// �����У������ʹ�ñ��������µ���ʽ��
class StackX
{
	private final int SIZE = 20;
	private int[] st; //�������飬�����������з����ڴ�
	public StackX()           // constructor
	{
		st = new int[SIZE];   // ������constructor�з����ڴ�
		for (int i = 0; i < vex.length; i++) {
			vex[i] = new Vertex(); //���ڴ���ֻ������nullָ�룬��û��ʵ��new����vex[i]��ָ�룬���Ƕ��󣡣���
			//......
		}	
		//......
	}
	//......}

//============Java PriorityQueue(��heap)�� Comparator��ʹ��============
// PriorityQueue�ڲ����Ƚ�ʱ������ͨ��comparator���бȽϣ����û���ṩcomparator����ô�����Ԫ�ص���Ȼ˳����бȽϡ�
// PriorityQueue�Ǹ��������ȼ��ѵļ������ȼ�����
// ��ʵ�ֲ���ͬ���ģ������̰߳�ȫ�ģ�����ʹ���̰߳�ȫ��PriorityBlockingQueue��
// ��ʵ��Ϊ���뷽����poll()��remove() ��peak()��add()��offer()�������ṩ O(log(n))ʱ��
// �ö�����������ʵ�֣����������С���Զ�̬���ӣ���������
public interface Comparable<T> { public int compareTo(T o); }
PriorityQueue(int initialCapacity) //ʹ��ָ���ĳ�ʼ��������һ��PriorityQueue��ʹ��Ĭ�ϵĳ�ʼ������11��

Queue<Integer> qi = new PriorityQueue<Integer>();
qi.add(5); qi.add(9); //���ڻ���������Integer�ȣ�����ֱ�Ӳ��룻���Ƕ��ڶ�������Ҫͨ���Ƚ���Comparator

//=======IntegerҲ����ͨ���Ƚ���=======
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

//=======���ڶ�����һ����Ҫͨ���Ƚ���Comparator=======
// ָ��PriorityQueue�ĳ�ʼ��С10����һ�������ڲ���ʼ����
PriorityQueue<MyThread> q = new PriorityQueue<MyThread>(10, new Comparator<MyThread>() {
    public int compare(MyThread o1, MyThread o2) {
        return o1.weight - o2.weight;
    }});
q.offer(new MyThread(5));
q.offer(new MyThread(7));
q.offer(new MyThread(2));
System.out.println(Arrays.toString(q.toArray()));

//==========================Java��������Ч����PriorityQueue����==========================
import java.util.*; //��仰��Ҫ
/*Note: �����connections ������List����*/
//�����costС����ǰ��
Collections.sort(connections, new Comparator<Connection>() {
	@Override
	public int compare(Connection o1, Connection o2) {
		return o1.cost - o2.cost;
	}});


//======================Stack��ʹ��======================
Stack<Integer> s = new Stack<Integer>(); // Ҫ��int����ʱ����ʹ��int�İ�װ��Integer
Stack<String> s = new Stack<String>();
Stack<Character> stack = new Stack<Character>(); // JRE 1.5�Ű���Character����
s.push("aa"); 			// ��ջ
String str1 = s.pop(); 	// ��ջ
String str2 = s.peek();	// peek at top of stack
if(s.isEmpty() == true)		// check whether it is empty
	System.out.println("it is empty!");

	
//======================ArrayList��remove()������Ҫ������======================
//��Ϊ���ϵĴ�С�Ƕ�̬�仯�ģ�����ɾ��һ��Ԫ��֮��Ԫ���е�������������У�������Ҫ��j--��
ArrayList<String> line= new ArrayList<String>();
for (int j = 0; j < line.size(); j++)
{line.remove(j); j--;}

//======ArrayList��remove()�������======
List list = new ArrayList();
list.add("0");
list.add("1");
list.remove(0);
������ǣ�list.get(0)�Ľ���ǡ�1��; 
��ע�������һ�Ρ�list.remove(0);����ôlist������Ǹ��ա�

//======================ArrayList�ı���======================
ArrayList<Integer> numList = new ArrayList<Integer>();
//......����numList.add(x)���������������
for(int j=0; j<numList.size(); j++)
	if(numList.get(j) < numList.get(minIndex))
		minIndex = j; //����Сֵ������
	
//======================List��ArrayList��ʹ��======================
	//ArrayList��ά�����ʹ��
	//ע�������new ArrayList<ArrayList<String>>()�����Ǵ�ģ�ֻ����ArrayList<List<String>>()
	List<List<String>> StrList = new ArrayList<List<String>>();
	
	StrList.add(new ArrayList<String>()); //һ����Ҫ����������������������
	StrList.add(new ArrayList<String>());
	StrList.get(0).add("LoanID");		//��һ���������
	StrList.get(1).add("newFineAmt");	//�ڶ����������
			
List List = new ArrayList();
int test1=0;
float test2 = (float) 0.001;
List.add(test1);
List.add(test2); //���粻ָ��List���ͣ����Դ�Ų�ͬ����
1.����һ��ָ���Ļ�����ֻ�ܴ�Ŷ���Integer����int��
List<Integer> List = new ArrayList<Integer>();

//======================ArrayList��add()��set()��������Ҫ����======================
ArrayList<String> newAttriList = new ArrayList<String>();
����>>> newAttriList.set(10, 100); //��10��λ�÷���ֵΪ100������
====ע���������Index��Χ���������Ϊset()����ʹ��ǰ������λ��10Ҫ�Ѿ���һ��ռ�
���ԣ�����newAttriList.add(...)������ݣ��ٿ���set()

//======================List��ArrayList��ʹ��======================
List<Integer> List = new ArrayList<Integer>(); //ָ����Integer����
List List = new ArrayList(); //��ָ�����󣬿��Դ������Ԫ��
List.add(1);
List.set(0,12);		//ע��: set(...,...)����ĳ���ض���element
list.get(i);		//ע��: ��list�б��л�ȡԪ��Ҫʹ��get(...)����
list.remove(1);		//ע�⣺remove��ArrayList�ᶯ̬�������飬ĳ��iԪ�ػᱻ��������鶯̬����
List1.clear();  	//The list will be empty after ��clear()������List1.size()���۲췢�ִ�С�Ѿ���Ϊ0

//======================Queue��ʹ��======================
// Queue�ӿ���List��Setͬһ���𣬶��Ǽ̳���Collection�ӿڡ�
// LinkedListʵ����Queue�ӿڡ�Queue�ӿ�խ���˶�LinkedList�ķ����ķ���Ȩ��
����˵��Queue<Integer> que = new LinkedList<Integer>();
�±���ʾ��jdk1.5�е��������еĲ�����
remove   �Ƴ������ض���ͷ����Ԫ��    �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
element  ���ض���ͷ����Ԫ��          �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
offer    ���һ��Ԫ�ز�����true      ��������������򷵻�false
poll     �Ƴ������ʶ���ͷ����Ԫ��    �������Ϊ�գ��򷵻�null
peek     ���ض���ͷ����Ԫ��          �������Ϊ�գ��򷵻�null
add      ����һ��Ԫ��                ����������������׳�һ��IIIegaISlabEepeplian�쳣
put      ���һ��Ԫ��                �����������������
take     �Ƴ������ض���ͷ����Ԫ��    �������Ϊ�գ�������

//======================LinkedList��ʹ��======================
LinkedList<Integer> que = new LinkedList<Integer>();
// que.poll() �� que.offer() ������Queue; 
if(!que.isEmpty())
{
	que.offer(199);	//offer()��add()����һ����add������List��offer������queue
	int i = que.poll(); //�Ƴ������ص�һ�����ݣ��ؼ��Ǵ����Ƴ�����
	
	que.add(199); 	//�����ָ�������Ļ���Ԫ�ؽ�����ӵ���������
	
	que.removeFirst();	//��poll()����������
	que.removeLast();
	
	//Ҳ���԰�������ջ���߶���������
	que.addFirst(299);
	que.addLast(399); //addLast()�����Ͳ���������add()����ʵ�ֵ�Ч��һ��}

//��LinkedListת����ArrayList
ArrayList<String> arrayList = new ArrayList<String>(linkedList); 

//ʹ��������ʵ�ֶ���Ч��
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

//ͬ������
LinkedList queue = new LinkedList(); 
queue = (LinkedList) Collections.synchronizedList(queue);
//======================HashMap======================
// HashMap<String , Double> map = new HashMap<String , Double>();   
// map.put("����" , 80.0);
HashMap<String, String> hashMap = new HashMap<String, String>();  
hashMap.put("cn", "�й�");
hashMap.put("jp", "�ձ�");
hashMap.put("fr", "����");
  
System.out.println(hashMap); 	//���: {jp=�ձ�, cn=�й�, fr=����},
System.out.println("cn:" + hashMap.get("cn"));	//���: cn:�й�
System.out.println(hashMap.containsKey("cn"));	//���: true
System.out.println(hashMap.keySet());	//���: [jp, cn, fr] 	
System.out.println(hashMap.isEmpty());	//���: false
  
hashMap.remove("cn");
System.out.println(hashMap.containsKey("cn"));	//���: false

//=============hashMap����һ�ֱ���=============
for (String key : map.keySet()){
	//value = map.get(key)}
//=============hashMap�ڶ��ֱ�������������Iterator����HashMap=============
Iterator it = hashMap.keySet().iterator();  
while(it.hasNext()) {  
	String key = (String)it.next();  
	System.out.println("key:" + key);  
	System.out.println("value:" + hashMap.get(key));  }

//============List �� HashMap ��ϵľ����÷�(����Scanner�ľ������뷨)============
//���屣��ѧ����Ϣ��List��Ԫ������ΪHashMap  
List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
Scanner input = new Scanner(System.in);  
  
System.out.println("������ѧ������Ϣ,y��ʾ������n��ʾ�˳�");  
while("y".equals(input.next())) {  
	HashMap<String, Object> map = new HashMap<String, Object>();  
	System.out.println("������ѧ��");  
	map.put("studentno", input.next());	// next()��Ĭ������String����
	System.out.println("����������");
	map.put("name", input.next());  	// next()��Ĭ������String����
	System.out.println("����������");  
	map.put("age", input.nextInt());	// nextInt()��ʾ�������ͣ�nextFloat()��float����
	list.add(map);  
	System.out.println("���������ѧ������Ϣ,y��ʾ������n��ʾ�˳�");  }   
System.out.println("ѧ������Ϊ:" + list.size());
Iterator<HashMap<String, Object>> it = list.iterator();
int i = 1;
while(it.hasNext()) {
	HashMap<String, Object> stuMap = it.next();  
	System.out.print("��" + i + "��ѧ������ϢΪ");  
	System.out.println("ѧ��:" + stuMap.get("studentno") + " ,����:" + stuMap.get("name") + " ,����:" + stuMap.get("age"));
	i++; //???}

/** ==========================Java���ͣ�Comparable<T>============================*/
���˽�һ�£�Comparable�ǹ����ӿ�
public interface Comparable { public boolean compareTo(T other); }

/** 
 * <T extends Comparable>������ʽ�ǳ���Ҫ��������compareTo����������Comparable��
 * a > b ��a.compareTo(b) > 0, 
 * a = b ��a.compareTo(b) == 0, 
 * a < b ��a.compareTo(b) < 0
 * */
class compare<T extends Comparable>
{	
	/*T cmp1; T cmp2;
	public compare(T cmp1, T cmp2){ //��������
	  this.cmp1 = cmp1; this.cmp2 = cmp2;
	},*/
	public T max(T t1, T t2) { 
		if (t1.compareTo(t2) > 0)
			return t1;
		else 
			return t2;
	}
	/*//���Զ�Comparable�Ľӿں���compareTo������д��ʵ�ֲ�ͬ����
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}*/}
��main()�������н��в��ԣ�
int m1 = 0; int m2 = 5;
compare<Integer> test1 = new compare(); //ע����������Ϊ<Integer>
System.out.println(test1.max(m1, m2));
>> �����5

float mm1 = (float) 9.9; float mm2 = (float) 8.8;
compare<Float> test2 = new compare();	//ע����������Ϊ<Float>
System.out.println(test2.max(mm1, mm2));
>> �����9.9







/*===============================����ģ�壺 java STDIN����=============================*/
import java.util.*;
import java.io.*;
class beads
{
    public static void main(String[] args) throws Exception
	{
		/*=============Java STDIN=============
        //Scanner input = new Scanner(new File("beads.in")); //���ļ��ж���
		Scanner input = new Scanner(System.in);		//�����ж���
		String inputString = input.nextLine(); 		//input a line of string
		String str[]=inputString.split("\\s+");		//"\\s+" denotes ���ݿո����۶��ٿո񣬷ֳɺܶಿ��
		*/
		//=============Java STDIN�� �ڶ��ֱ�׼����=============
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
        try { 
        	inputString = stdin.readLine();	
        },catch (IOException ex){ 
        	System.out.println(ex); 
        }, 	
        //String inputString1 = stdin.readLine(); // <<<<<< ����ֱ������1
        //String inputString2 = stdin.readLine(); // <<<<<< ����ֱ������2	
		
		//=============Java STDOUT=============
		System.out.println(inputString);
        //PrintWriter output = new PrintWriter("beads.out");
		//...
        //output.close();
	}}

/*===============================����ģ�壺 java STDINѭ���������=============================*/
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
1.��õķ�����ѭ���ҳ���λ�ӵ�listԪ��
for(int i = 0;i < list.size(); i++){
	System.out.println(list.get(i));}
2.����Iterator ���while����
Iterator it1 = list.iterator();
while(it1.hasNext()){
	System.out.println(it1.next());}
3.����Iterator ���forѭ��(�͵�2�ַ�������)
for(Iterator it2 = list.iterator();it2.hasNext();){
	System.out.println(it2.next());}
4.��򵥵ķ���
for(String tmp:list){
	System.out.println(tmp);}

/////////////////////////////StackXʵ�ֵ��ڲ�����//////////////////////////////
class StackX
{
	private final int SIZE = 20;
	private int[] st; //�������飬�����������з����ڴ�
	private int top;

	public StackX()           // constructor
	{
		st = new int[SIZE];   // make array
		top = -1;	//ע���ʼ��Ϊ-1
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

//==============================Java��Socket���===============================
// private InetAddress address;	//���ߵ�address���Ͷ���InetAddress
byte byteAddr[] = { 127, 0, 0, 1 };
int port = 10023;
InetAddress address = InetAddress.getByAddress(byteAddr);
//============Socket�ͻ��˵�һ�����ӷ�ʽ============
Socket socket = new Socket();
SocketAddress saddr = new InetSocketAddress(address, port);
socket.connect(saddr);
//============Socket�ͻ��˵ڶ������ӷ�ʽ============
Socket socket = null;
socket = new Socket(address.getHostAddress(), port);

OutputStream outStream = socket.getOutputStream();	//��outStreamд���ݣ���ʾ�������ݵ�����
InputStream inputStream = socket.getInputStream();	//��inputStream�����ݣ��������ⲿ
//�ڼ䣬����socket�Ķ�д����......
inputStream.close();	//һ���Ȱ�inputStream�������ر�
socket.close(); 		//�ٹر�socket

//================Java����ģʽ(singleton pattern)================
public class Batch
{
	private Map<String, Command> commands;
	
	private static class BatchInstance 
	{ private static final Batch instance = new Batch();}
	
	public static Batch getInstance() //ע�������static�����Ա�Batch.getInstance()
	{ return BatchInstance.instance; }
	
	private Batch() //ע�⹹������������"private"�������ǹ��õ�public
	{/*...*/}	//ֻ���ڵ�һ�ε���Batch.getInstance()��ʱ�򣬲�ʹ��һ�ι��캯��������
	
	public void addCommand(Command command){/*...*/}
	public Map<String, Command> getCommands() {return commands;}}
//���������ļ��п��Բ����������
Batch bat = Batch.getInstance(); //important: obtain instance of Batch
bat.addCommand(cmd);
Map<String, Command> map = bat.getCommands();


//==========================��������������=========================
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
��ô������
Node rootNew = (Node)root.clone(); //�����ִ�Ķ���������root���ڵ�����

//==========================SZM:�޸ĺ�Ķ��������=========================
class Node implements Cloneable
{	
	public String attribute; 	
	public String arrived_value;
    ArrayList<Node> childs = new ArrayList<Node>();	//�ӽ�㼯�ϣ�ע�����Ƕ����
    Node() {
    	attribute = null;
    	arrived_value = null;
    	//childs = new ArrayList<Node>();
    }
	protected Object clone() //���������
	{
		try {
			Node treeClone = (Node)super.clone();
			//�����������ǳ��Ƚϣ��൱��Ϊ�¿�¡��treeClone��childs������һ���ڴ棻��Ȼ���������
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
��ô������
Node rootNew = (Node)root.clone(); //�����ִ�Ķ���������root���ڵ�����

//=======================Java �����ļ��к�Ŀ¼=======================
	try{
		/*����Ŀ¼����������ڣ��ʹ���*/
		File dirFile = new File("e:/test");
		if(!dirFile.exists()){
			if(!dirFile.mkdir())
				throw new Exception("Ŀ¼�����ڣ�����ʧ�ܣ�");
		}
		/*�����ļ�����������ڣ��ʹ���*/
		File file = new File("e:/test/text1.txt");
		if(!file.exists())
			if(!file.createNewFile())
				throw new Exception("�ļ������ڣ�����ʧ�ܣ�");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}

/** ################### ����T�ķ��ͻ�Comparableʹ�� ###################
 * <T extends Comparable>������ʽ�ǳ���Ҫ��������compareTo����������Comparable��
 * a > b ��a.compareTo(b) > 0, 
 * a = b ��a.compareTo(b) == 0, 
 * a < b ��a.compareTo(b) < 0 
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
ʵ��������ʹ��>>>>
compare<String> cmp = new compare();
boolean result = cmp.compareTwoNum(m1, m2, operator); //true or false


/** ############################# FileOutputStream #############################*/
//===================���һ���ļ����е������ļ���===================
File file=new File("D:\\");
String test[];
test=file.list();
for(int i=0;i<test.length;i++)
{
	System.out.println(test[i]);}

//===================������������һ���ļ������ļ���д����===================
File f = new File("a.txt");
// ����FileOutputStream����,�ļ������ڻ��Զ��½�
FileOutputStream fop = new FileOutputStream(f);
// ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk
OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

writer.append("��������"); 	// д�뵽������
writer.append("\r, "); 		// ����
writer.append("English"); 	// ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��

//ǧ��ע�⣺writer��fop��˳��
writer.close();				// �ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�
fop.close(); 				// �ر������,�ͷ�ϵͳ��Դ

//===================���ļ��ж�ȡ���ݣ�StringBuffer��ȡ����һ���ַ�===================
File f = new File("a.txt");
// ����FileInputStream����
FileInputStream fip = new FileInputStream(f);
// ����InputStreamReader����,������д����ͬ
InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
// ת��char�ӵ�StringBuffer������
StringBuffer sb = new StringBuffer();
while (reader.ready()) {
	sb.append((char) reader.read());}
System.out.println(sb.toString());
reader.close(); // �رն�ȡ��
fip.close(); // �ر�������,�ͷ�ϵͳ��Դ

//===================���ļ��ж�ȡ���ݣ�BufferedReader��ȡ����һ���ַ�===================
try {
	File file = new File("a.txt");
	FileInputStream fi = new FileInputStream(file);
	InputStreamReader ir = new InputStreamReader(fi);
	BufferedReader br = new BufferedReader(ir);
	
	String str = br.readLine().trim();	//��ȡһ��
	//char chr = (char) br.read();	//��ȡһ���ַ� <====��������Զ�ȡ���ַ��Ƚ��ң�����
	
	String tmp = br.readLine().trim();
	for(int j=0; j<tmp.length(); j++)
	{
		data[j] = Integer.parseInt(String.valueOf(tmp.charAt(j))); //���ַ�charת����int
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

���������ؼ���synchronized��:
b.Java����Ĭ���ǿ��Ա�����̹߳��õģ�ֻ������Ҫʱ�������������������ƣ���Ϊר�ö���
c.�ؼ���synchronized���������Ļ�������ϵ
d.��ĳ��������synchronized����ʱ�������ö����������������������ƣ�����һʱ��ֻ����һ���̷߳��ʣ�
��ʹ���̳߳��ֶ������ö���ı�����״̬Ҳ�������������߳��β��ܷ��ʸö���

Java���÷���:
static void sleep(long t) //�ͷ�CPU��ִ��Ȩ�����ͷ���
final void wait() 	//�ͷ�CPU��ִ��Ȩ���ͷ���
final void notify()	//
static void yield() //���ԶԵ�ǰ�߳̽�����ʱ��ͣ�����߳̽���Դ�ͷų�����
public final void join() //��ǰִ��join�������̻߳ᱻ���ᣬ�ȴ���ǰ�߳�ִ�н���������join(2000)
isAlive()

//===========================================================
�����̵߳ķ���(������run��������)��
1. run������ͨ���ᶨ��ѭ���ṹ������ֻҪ����סѭ������
2. ����boolean��ǵ���ʽ��ɣ�ֻҪ��ĳһ����½���Ǹı䣬��ѭ��ֹͣ�������߳̽���
3. ִ������һ�̵߳�join()���������߳̽�����ʱ�򣬸��̲߳Ż�ָ���������״̬? �� ������
private volatile boolean done = false; //ʹ����volatile�ؼ��֣�����Ҫ��Ϊ��ͬ��???
public void setDone(){	//���÷���setDone()ȥ�����߳�
	done = true;}
public void run() {
	while(!done){
		//...task...
		try {Thread.sleep(1000);}, catch (InterruptedException ie) {return;},
	}}

//=========================Runnable���ŵ�=========================
//Runnable���ŵ㣺http://www.oschina.net/question/565065_86563
�ڳ��򿪷���ֻҪ�Ƕ��߳̿϶���Զ��ʵ��Runnable�ӿ�Ϊ������Ϊʵ��Runnable�ӿ�
//ʹ��Runnable�����������û��start()������ֻ��Thread���в��У�
//public Thread(Runnable targer)�˹��췽������Runnable������ʵ��
public interface Runnable{
public void run();}
//һ��ʹ�÷�ʽ��
Thread thread = new Thread(new Runnable(){
       @Override
       public void run(){
          ...
       }});
thread.start();

Runnable���ŵ㣺
1. �����̳еľ��ޣ�һ������Լ̳ж���ӿڡ�
2. �ʺ�����Դ�Ĺ���(�������Ʊ������)

Runnable�ӿں�Thread֮�����ϵ��
public class Thread extends Object implements Runnable //����Thread��Ҳ��Runnable�ӿڵ�����

//====================Runnable��Thread��Ҫ����(��Դ����)======================
// Runnable�ӿ�һ������10��Ʊ��Ҳ����˵ʹ��Runnableʵ�ֶ��߳̿��Դﵽ��Դ����Ŀ�ġ�
// ����Thread��ÿ���̶߳�������10�ţ�������20��Ʊ��ÿ���̶߳����Լ���Ʊ��û�дﵽ��Դ����
public static void main(String[] args) {
	//====================Runnable�ӿ�����====================
	//====��һ����ʽ====
	Thread t1 = new Thread(new MyRunnable(), "t1");
	//Thread t2 = new Thread(new MyRunnable(), "t2");
	t1.start();	//�ܹؼ������������̣߳�������MyRunnable���е���Դ
	t1.start();
	//====�ڶ�����ʽ====
	//MyRunnable t1 = new MyRunnable();
	//new Thread(t1).start(); //����ͬ��
	//new Thread(t1).start();
	
	t1.join();	//ͬ���ȴ���ֱ��t1�߳̽���
	
	//====================Thread����====================
	MyThread mt1=new MyThread("�߳�a");
	MyThread mt2=new MyThread("�߳�b");
	mt1.start();	//���ƣ����������̣߳������ܹ���MyThread���е���Դ
	mt2.start();
	
	//mt1.start(); mt1.start(); //��Ȼ�����������Σ�����ʵ��ֻ�ǵ�һ����Ч}
class MyRunnable implements Runnable{ //Runnable�ӿڷ�ʽ
	private int ticket=10;
	@Override	
	public void run(){  
		for(int i=0;i<20;i++){
			if(this.ticket>0)
				System.out.println("��Ʊ��ticket"+this.ticket--);  
		}
	}}
class MyThread extends Thread{ //Thread�෽ʽ
	private int ticket=10;
	@Override	
	public void run(){  
		for(int i=0;i<20;i++){
			if(this.ticket>0)
				System.out.println("��Ʊ��ticket"+this.ticket--);  
		}
	}}

















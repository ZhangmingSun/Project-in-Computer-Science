
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
DFS : �����������������ȶ��ǣ����

XXX dfs(TreeNode root, ...)
{
	//����������Ĳ���Ҷ�ڵ㣬����ֻ��һ���ӽڵ�Ľڵ㣬
	//��Ϊif(root.left==null && root.right==null)�ж�Ҷ�ڵ㣬����ǰreturn
	if(root==null) return ...;

	if(root.left==null && root.right==null) //Ҷ�ڵ��ж�����
	{
		//......
		return ; //����Ҷ�ڵ���ǰ����
	}
	dfs(root.left, ...);
	dfs(root.right, ...);
}
//***********************************************************************************************************
// "if(root==nullptr) return ...;" --ֻ�ǵݹ���ֹ������������ʾ��ǰ�ڵ��ǡ�Ҷ�ڵ㡱��
// ��Ϊ��Щ�ڵ���ӽڵ�ֻ��һ����Ҫ���ģ�����

void Search(TreeNode root, ...)
{
	//����������Ĳ���Ҷ�ڵ㣬����ֻ��һ���ӽڵ�Ľڵ㣬
	//��Ϊif(root.left==null && root.right==null)�ж�Ҷ�ڵ㣬����ǰreturn
	if(root==null) return ...;	
	
	//�ο���Ҷ�ڵ��ж�������һ�������ų�����ǰ�ڵ�ֻ��һ���ӽڵ�������
	if(root.left==null && root.right==null) //
	{
		//......
		return ; //����Ҷ�ڵ���ǰ����
	}
	l = Search(root.left, ...);
	r = Search(root.right, ...);
	
	// ���Զ����������ķ���ֵ "l��r" �����жϣ�����·��Sum����
	// ......
	
	//���緵�������� max(l,r)+1����С���min(l,r)+1 (ע����С��ȣ����迼�� l=0&&r!=0 ���� r=0&&l!=0 �����)
	return ...;
}
//***********************************************************************************************************

//==========================================
//	 ���ض�������root��Ҷ�ڵ����С���
//==========================================
Note: ��С��Ȼ���Ҫ�ر��ǡ�ֻ��right�ӽڵ㡱�͡�ֻ��left�ӽڵ㡱�������
public int minDepth(TreeNode root) {
	if(root == null)    //ֻ��һ�����ã���ֹ���������[]
		return 0;
	if(root.left == null && root.right == null) //�ж�Ҷ�ڵ������
		return 1;
		
	int min;
	if(root.left == null && root.right != null)	//ֻ��right�ӽڵ��node
		min = minDepth(root.right);
	else if(root.left != null && root.right == null) //ֻ��left�ӽڵ��node
		min = minDepth(root.left);
	else    //���node�������ӽڵ�
		min = Math.min(minDepth(root.right), minDepth(root.left));  //����������������С���

	return min+1;
}

//==========================================
//���ض�������root��Ҷ�ڵ��������(��Ȼ��Ҷ�ڵ���ж�����Ҳ����Ҫ)
//==========================================
public int maxDepth(TreeNode root) {
	if(root == null)    //ֻ��һ�����ã���ֹ���������[]
		return 0;
	//if(root.left == null && root.right == null) //�ж�Ҷ�ڵ������
		//return 1;
	int max;
	max = Math.max(maxDepth(root.right), maxDepth(root.left));  //��������������������
	return max+1;
}

//==========================================
//Path Sum I��check��root-to-leaf path�ĺ��Ƿ����sum������boolean(ֻҪ��һ��true�����շ��ؾ���true)
//˼·�ǵݹ��ʱ��sum���μ�ȥroot.val
//==========================================
public boolean hasPathSum(TreeNode root, int sum) {
	if(root==null) //��������ǿ�����[]�����ߵ�ǰnodeֻ��һ���ӽڵ�
		return false;

	if(root.left==null && root.right==null){ //Ҷ�ڵ��ж�����
		if(root.val == sum) return true; //�����ȣ�˵����Ҷ�ڵ�Ϊֹ����������	
		else return false;
	}
	boolean left = hasPathSum(root.left, sum - root.val); //�ܹؼ�"sum-root.val"
	boolean right = hasPathSum(root.right, sum - root.val);
	
	return right || left;   // ��||����ʾֻҪ��һ����ȷ����
}

//==========================================
//Path Sum II�����ء���root-to-leaf path�ĺ͵���sum����ȫ��·��
//LinkedList����ջʹ�ã������м���
//==========================================
public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> result = new LinkedList<List<Integer>>(); //����·�����
	//ע�⣺List�ӿ�ûaddFirst()��removeFirst()��������LinkedList��
	LinkedList<Integer> tmpList = new LinkedList<Integer>(); //���ڵ�ǰ����ʱ·��
	pathSum(root, sum, result, tmpList); //�Զ���������������浽result��
	return result;
}

public void pathSum(TreeNode root, int sum, List<List<Integer>> result, LinkedList<Integer> tmpList)
{
	if(root==null) //��������ǿ�����[]�����ߵ�ǰnodeֻ��һ���ӽڵ�
		return;

	tmpList.add(root.val);  //�൱��push
	if(root.left==null && root.right==null){ //Ҷ�ڵ��ж�����
		if(root.val == sum){ //�����ȣ�˵����Ҷ�ڵ�Ϊֹ����������
			result.add(new LinkedList<Integer>(tmpList)); //��tmpList��ʼ���½�����
			/*result.add(new LinkedList<Integer>());
			for(int i=0; i<tmpList.size(); i++)
				result.get(result.size()-1).add(tmpList.get(i)); //��tmpList�������ݿ�����result���һ��
			*/
			//��������������������أ�result.add��ӵ���tmpList��ָ�룬����result�������ͬ��������!!!
			//result.add(tmpList);
		}
		tmpList.removeLast(); //�൱��pop
		return;
	}
	pathSum(root.left, sum - root.val, result, tmpList);
	pathSum(root.right, sum - root.val, result, tmpList);
	tmpList.removeLast(); //�൱��pop
}
//==========================================
//Binary Tree Maximum Path Sum�����ض��������������ڵ������·����
//��Ϊ����ڵ㣬������һȫ�ֱ���maxSum��ÿһ���ڵ���������а�(left+right+root.val)��maxSumʵʱ�Ƚ�
//==========================================
public int maxSum = java.lang.Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
	dfs(root);  //ע�⣺dfs����ֻ�Ǿֲ���󣬵����ڲ�ʵʱ����maxSum
	return maxSum;
}
public int dfs(TreeNode root) {
	if(root == null)
		return 0;
		
	int l = dfs(root.left);
	int r = dfs(root.right);
	
	int sum = root.val;
	if(l > 0) sum = sum + l;
	if(r > 0) sum = sum + r;
	maxSum = Math.max(maxSum, sum);

	if(Math.max(l, r) < 0) //���l,r��Ϊ������l,r,root.val�������з������ֵ
		return Math.max(Math.max(l, r), root.val);
		//return root.val; //Ϊʲô��������Ҳ��???
	else    //ע���ڷ��ص�ʱ��ֻ�ܴ����ҷ�֧�У���ѡ��֧������һ������
		return Math.max(l, r) + root.val;
}

//==========================================
// Populating Next Right Pointers in Each Node
// �е��ƿڣ��ؼ���⣺�����������룬siblingҲ�ڲ��ϱ仯��
//==========================================
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
	
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL	
	
public void connect(TreeLinkNode root) {
	connect(root, null);
}
public void connect(TreeLinkNode root, TreeLinkNode sibling) {
	if(root == null)
		return;
	root.next = sibling;
	//��һ��������left��right
	connect(root.left, root.right);
	//�ڶ�������������������right��sibling
	if(sibling != null)
		connect(root.right, sibling.left); //�ؼ�Ҫ�����һ�䣡����
	else
		connect(root.right, null);
}

//==========================================
// Sum Root to Leaf Numbers
// ����LinkedList������ջ����Ҷ�ڵ��У���·�����ۼ�
//==========================================
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.

public int finalSum = 0;
public int sumNumbers(TreeNode root) {
	LinkedList<Integer> tmp = new LinkedList<Integer>();
	dfs(root, tmp);
	return finalSum;
}
public void dfs(TreeNode root, LinkedList<Integer> tmp) {
	if(root == null)
		return;
	tmp.add(root.val); //�൱��push
	if(root.left == null && root.right == null) { //�ж�Ҷ�ڵ������
		String str = "";
		for(int i=0; i<tmp.size(); i++)
			str = str + "" + tmp.get(i);
		finalSum += Integer.parseInt(str);
		//tmp.removeLast(); //�൱��pop
		//return;
	}
	dfs(root.left, tmp);
	dfs(root.right, tmp);
	tmp.removeLast(); //�൱��pop
}

//==========================================
// ���ض���������"�ڵ�"�ĺ�
//==========================================
public int dfs(TreeNode root) {
	if(root == null)
		return 0;
	
	int l = dfs(root.left);
	int r = dfs(root.right);
	return l + r + root.val;
}

//==========================================
// ���ض���������"Ҷ�ڵ�"�ĺ�
//==========================================
public int dfs(TreeNode root) {
	if(root == null)
		return 0;
	
	if(root.left == null && root.right == null) { //�ж�Ҷ�ڵ������
		return root.val;
	int l = dfs(root.left);
	int r = dfs(root.right);
	return l+r;
}




//***********************************************************************************************************
// ���ַ����������⡰mid-1���͡�mid+1�����ͽ�ֹ������if(start>end) return nullptr;��
// ���Լ��ܽ��ˡ����ַ�����5���ص�
// ������Convert Sorted Array to Binary Search Tree
//***********************************************************************************************************
//����Ĺؼ��Ƕ��ַ�����������ҪŪ������ѳ�ʼ���롰length-1�������Ҳ��ܵ�������˫�������ն���start=end�����
TreeNode* sortedArrayToBST(vector<int>& nums)
{   int length = nums.size();
	if(length==0) return nullptr;
	
	return Convert(nums, 0, length-1); //ע�����һ��Ҫ��һ������������걣��һ�£�����
}

TreeNode* Convert(vector<int>& nums, int start, int end)
{
	if(start>end) return nullptr;   //��ߵĽ�ֹ����ֻ����start>end����Ϊ���ܵ�������˫��������start=end�����

	int mid = (start+end)/2; 
	TreeNode* node = new TreeNode(nums[mid]);
	node->left = Convert(nums, start, mid-1);    //ǧ��ע�⣺mid-1
	node->right = Convert(nums, mid+1, end);     //ǧ��ע�⣺mid+1
	return node;
}

//================================
//	 SZM�����ַ�����6���ص�
//================================	
�ص�1���������upperBoundһ���õ��ڡ����鳤��-1�����磺devide(nums, 0, length-1) <<<������
�ص�2����ֹ����ֻ����start>end �� lowerBound > upperBound�����ܵ��ںţ����ܵ�������˫�������ն���start=end�����
�ص�3���м������󷨣�mid = (end+start)/2
�ص�4���µ�upperBound����mid-1
�ص�5���µ�lowerBound����mid+1
�ص�6���ݹ��ֹ������if(start>end) return nullptr;�����ܷ��ؾ������֣�����������

//=============================================
// �鲢�����С����ַ����е㲻һ������ȡ���ھ����Ӧ��
//=============================================
�µ�lowerBound����mid���µ�upperBound����mid+1��
��ֹ������if(lowerBound == upperBound) return;
���������α�

//=====================================================
//====int Sqrt(int x), �ö��ֲ��ҷ�(whileѭ��ʵ��)=====
//=====================================================
    public int Sqrt(int x) 
    {
        if(x==0) return 0;
        //������long����, ��Ϊ"first+last"���ܻᳬ��int�ķ�Χ
        long first=1,last=x;	//����Ҫ����β����
        while(first<last) 		//������ǵݹ�ʵ���е�ֹͣ����������
		{  
            long mid=(first+last)/2; 
            if(mid*mid<x) first=mid+1; 
            else if(mid*mid>x) last=mid-1;  
            else return (int)mid;
        }
		//������Sqrt()�е��������
        if(first*first>x) return (int)first-1;  
        else return (int)first;
    }
//***********************************************************************************************************




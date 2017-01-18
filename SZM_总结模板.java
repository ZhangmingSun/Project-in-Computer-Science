
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
DFS : 中序遍历，先序遍历等都是，最常见

XXX dfs(TreeNode root, ...)
{
	//进入此条件的不是叶节点，而是只有一个子节点的节点，
	//因为if(root.left==null && root.right==null)判断叶节点，并提前return
	if(root==null) return ...;

	if(root.left==null && root.right==null) //叶节点判断条件
	{
		//......
		return ; //并且叶节点提前返回
	}
	dfs(root.left, ...);
	dfs(root.right, ...);
}
//***********************************************************************************************************
// "if(root==nullptr) return ...;" --只是递归终止条件，并不表示当前节点是“叶节点”，
// 因为有些节点的子节点只有一个，要当心！！！

void Search(TreeNode root, ...)
{
	//进入此条件的不是叶节点，而是只有一个子节点的节点，
	//因为if(root.left==null && root.right==null)判断叶节点，并提前return
	if(root==null) return ...;	
	
	//牢靠的叶节点判断条件，一般用来排除“当前节点只有一个子节点的情况”
	if(root.left==null && root.right==null) //
	{
		//......
		return ; //并且叶节点提前返回
	}
	l = Search(root.left, ...);
	r = Search(root.right, ...);
	
	// 可以对左右子树的返回值 "l和r" 进行判断，比如路径Sum问题
	// ......
	
	//假如返回最大深度 max(l,r)+1，最小深度min(l,r)+1 (注意最小深度，还需考虑 l=0&&r!=0 或者 r=0&&l!=0 的情况)
	return ...;
}
//***********************************************************************************************************

//==========================================
//	 返回二叉树从root到叶节点的最小深度
//==========================================
Note: 最小深度还需要特别考虑“只有right子节点”和“只有left子节点”两种情况
public int minDepth(TreeNode root) {
	if(root == null)    //只有一个作用，防止输入空数组[]
		return 0;
	if(root.left == null && root.right == null) //判断叶节点的条件
		return 1;
		
	int min;
	if(root.left == null && root.right != null)	//只有right子节点的node
		min = minDepth(root.right);
	else if(root.left != null && root.right == null) //只有left子节点的node
		min = minDepth(root.left);
	else    //如果node有左右子节点
		min = Math.min(minDepth(root.right), minDepth(root.left));  //返回左右子树的最小深度

	return min+1;
}

//==========================================
//返回二叉树从root到叶节点的最大深度(竟然连叶节点的判断条件也不需要)
//==========================================
public int maxDepth(TreeNode root) {
	if(root == null)    //只有一个作用，防止输入空数组[]
		return 0;
	//if(root.left == null && root.right == null) //判断叶节点的条件
		//return 1;
	int max;
	max = Math.max(maxDepth(root.right), maxDepth(root.left));  //返回左右子树的最大深度
	return max+1;
}

//==========================================
//Path Sum I：check从root-to-leaf path的和是否等于sum，返回boolean(只要有一个true，最终返回就是true)
//思路是递归的时候，sum依次减去root.val
//==========================================
public boolean hasPathSum(TreeNode root, int sum) {
	if(root==null) //如果输入是空数组[]，或者当前node只有一个子节点
		return false;

	if(root.left==null && root.right==null){ //叶节点判断条件
		if(root.val == sum) return true; //如果相等，说明到叶节点为止，符合条件	
		else return false;
	}
	boolean left = hasPathSum(root.left, sum - root.val); //很关键"sum-root.val"
	boolean right = hasPathSum(root.right, sum - root.val);
	
	return right || left;   // “||”表示只要有一个正确就行
}

//==========================================
//Path Sum II：返回“从root-to-leaf path的和等于sum”的全部路径
//LinkedList当堆栈使用，保存中间结果
//==========================================
public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> result = new LinkedList<List<Integer>>(); //所有路径结果
	//注意：List接口没addFirst()和removeFirst()函数，而LinkedList有
	LinkedList<Integer> tmpList = new LinkedList<Integer>(); //用于当前的临时路径
	pathSum(root, sum, result, tmpList); //自动搜索，将结果保存到result中
	return result;
}

public void pathSum(TreeNode root, int sum, List<List<Integer>> result, LinkedList<Integer> tmpList)
{
	if(root==null) //如果输入是空数组[]，或者当前node只有一个子节点
		return;

	tmpList.add(root.val);  //相当于push
	if(root.left==null && root.right==null){ //叶节点判断条件
		if(root.val == sum){ //如果相等，说明到叶节点为止，符合条件
			result.add(new LinkedList<Integer>(tmpList)); //用tmpList初始化新建对象
			/*result.add(new LinkedList<Integer>());
			for(int i=0; i<tmpList.size(); i++)
				result.get(result.size()-1).add(tmpList.get(i)); //把tmpList所有内容拷贝到result最后一条
			*/
			//下面的这条语句问题很严重，result.add添加的是tmpList的指针，导致result所有项都相同，很严重!!!
			//result.add(tmpList);
		}
		tmpList.removeLast(); //相当于pop
		return;
	}
	pathSum(root.left, sum - root.val, result, tmpList);
	pathSum(root.right, sum - root.val, result, tmpList);
	tmpList.removeLast(); //相当于pop
}
//==========================================
//Binary Tree Maximum Path Sum：返回二叉树中任意两节点间的最大路径和
//因为任意节点，需设置一全局变量maxSum，每一个节点遍历返回中把(left+right+root.val)跟maxSum实时比较
//==========================================
public int maxSum = java.lang.Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
	dfs(root);  //注意：dfs返回只是局部最大，但它内部实时更新maxSum
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

	if(Math.max(l, r) < 0) //如果l,r都为负，从l,r,root.val，三者中返回最大值
		return Math.max(Math.max(l, r), root.val);
		//return root.val; //为什么这样返回也对???
	else    //注意在返回的时候，只能从左右分支中，挑选分支和最大的一个返回
		return Math.max(l, r) + root.val;
}

//==========================================
// Populating Next Right Pointers in Each Node
// 有点绕口，关键理解：随着搜索深入，sibling也在不断变化中
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
	//第一步：连接left和right
	connect(root.left, root.right);
	//第二步：根据条件，连接right和sibling
	if(sibling != null)
		connect(root.right, sibling.left); //关键要理解这一句！！！
	else
		connect(root.right, null);
}

//==========================================
// Sum Root to Leaf Numbers
// 利用LinkedList当作堆栈，在叶节点中，把路径和累加
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
	tmp.add(root.val); //相当于push
	if(root.left == null && root.right == null) { //判断叶节点的条件
		String str = "";
		for(int i=0; i<tmp.size(); i++)
			str = str + "" + tmp.get(i);
		finalSum += Integer.parseInt(str);
		//tmp.removeLast(); //相当于pop
		//return;
	}
	dfs(root.left, tmp);
	dfs(root.right, tmp);
	tmp.removeLast(); //相当于pop
}

//==========================================
// 返回二叉树所有"节点"的和
//==========================================
public int dfs(TreeNode root) {
	if(root == null)
		return 0;
	
	int l = dfs(root.left);
	int r = dfs(root.right);
	return l + r + root.val;
}

//==========================================
// 返回二叉树所有"叶节点"的和
//==========================================
public int dfs(TreeNode root) {
	if(root == null)
		return 0;
	
	if(root.left == null && root.right == null) { //判断叶节点的条件
		return root.val;
	int l = dfs(root.left);
	int r = dfs(root.right);
	return l+r;
}




//***********************************************************************************************************
// 二分法的坐标问题“mid-1”和“mid+1”，和截止条件“if(start>end) return nullptr;”
// 我自己总结了“二分法”的5个重点
// 举例：Convert Sorted Array to Binary Search Tree
//***********************************************************************************************************
//此题的关键是二分法的坐标问题要弄清楚：把初始输入“length-1”，而且不管单数还是双数，最终都有start=end的情况
TreeNode* sortedArrayToBST(vector<int>& nums)
{   int length = nums.size();
	if(length==0) return nullptr;
	
	return Convert(nums, 0, length-1); //注意这边一定要减一，跟数组的坐标保持一致！！！
}

TreeNode* Convert(vector<int>& nums, int start, int end)
{
	if(start>end) return nullptr;   //这边的截止条件只能是start>end，因为不管单数还是双数，都有start=end的情况

	int mid = (start+end)/2; 
	TreeNode* node = new TreeNode(nums[mid]);
	node->left = Convert(nums, start, mid-1);    //千万注意：mid-1
	node->right = Convert(nums, mid+1, end);     //千万注意：mid+1
	return node;
}

//================================
//	 SZM“二分法”的6个重点
//================================	
重点1：输入参数upperBound一定得等于“数组长度-1”，如：devide(nums, 0, length-1) <<<？？？
重点2：截止条件只能是start>end 或 lowerBound > upperBound，不能等于号，不管单数还是双数，最终都有start=end的情况
重点3：中间坐标求法：mid = (end+start)/2
重点4：新的upperBound等于mid-1
重点5：新的lowerBound等于mid+1
重点6：递归截止条件“if(start>end) return nullptr;”不能返回具体数字！！！？？？

//=============================================
// 归并排序中“二分法”有点不一样，这取决于具体的应用
//=============================================
新的lowerBound等于mid，新的upperBound等于mid+1，
截止条件是if(lowerBound == upperBound) return;
具体程序见课本

//=====================================================
//====int Sqrt(int x), 用二分查找法(while循环实现)=====
//=====================================================
    public int Sqrt(int x) 
    {
        if(x==0) return 0;
        //必须是long类型, 因为"first+last"可能会超出int的范围
        long first=1,last=x;	//很重要，首尾坐标
        while(first<last) 		//这个就是递归实现中的停止条件！！！
		{  
            long mid=(first+last)/2; 
            if(mid*mid<x) first=mid+1; 
            else if(mid*mid>x) last=mid-1;  
            else return (int)mid;
        }
		//下面是Sqrt()中的特殊情况
        if(first*first>x) return (int)first-1;  
        else return (int)first;
    }
//***********************************************************************************************************




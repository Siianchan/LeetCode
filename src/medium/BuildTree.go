package main

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

func main() {

}
func buildTree(preorder []int, inorder []int) *TreeNode {
	ret := &TreeNode{}
	if len(preorder) > 0 {
		bDfs(preorder, inorder, ret)
	} else {
		return nil
	}
	return ret
}
func bDfs(preorder []int, inorder []int, t *TreeNode) {
	x := 0
	//赋值给当前节点
	t.Val = preorder[0]
	if len(preorder) == 1 { //当只剩下一个节点时，赋值后直接返回
		return
	}
	for ; x < len(inorder); x++ {
		//查找左树，中点，右数
		if t.Val == inorder[x] {
			//中点，小于这个点的都是左树，大于这个点的都是右树
			break
		}
	}
	if x != 0 {
		//如果中点在第一个节点，说明没有左子树，就不继续构建
		t.Left = &TreeNode{}
		bDfs(preorder[1:x+1], inorder[:x], t.Left)
	}
	if x != len(inorder)-1 {
		//如果中点在最后一个节点，说明没有右子树，就不继续构建
		t.Right = &TreeNode{}
		bDfs(preorder[x+1:], inorder[x+1:], t.Right)
	}
}

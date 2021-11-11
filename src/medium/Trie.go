package main

/* Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
请你实现 Trie 类：
Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
*/

import "fmt"

type Trie struct {
	node  [26]*Trie
	isEnd bool
	//前缀树结构，node [26]代表26个字母
	//isEnd代表是否当前单词结尾字母
}

func Constructor() Trie {
	return Trie{}
}

func (th *Trie) Insert(word string) {
	//插入操作
	node := th
	for i := 0; i < len(word); i++ {
		if node.node[word[i]-'a'] == nil {
			//遍历插入字母到前缀树中
			node.node[word[i]-'a'] = &Trie{}
		}
		node = node.node[word[i]-'a']
	}
	//单词结尾
	node.isEnd = true
}

func (th *Trie) Search(word string) bool {
	node := th
	//前缀树查询
	for i := 0; i < len(word); i++ {
		if node.node[word[i]-'a'] == nil {
			//遍历查询，如果没有就返回false
			return false
		}
		node = node.node[word[i]-'a']
	}
	//全部遍历完成后，查看是否单词结尾
	return node.isEnd
}

func (th *Trie) StartsWith(prefix string) bool {
	node := th
	for i := 0; i < len(prefix); i++ {
		if node.node[prefix[i]-'a'] == nil {
			return false
		}
		node = node.node[prefix[i]-'a']
	}
	//查询以xx开头单词，直接返回true
	return true
}

func main() {
	ob := Constructor()
	ob.Insert("apple")
	fmt.Println(ob.Search("apple"))
	fmt.Println(ob.Search("appl"))
	fmt.Println(ob.StartsWith("app"))
}

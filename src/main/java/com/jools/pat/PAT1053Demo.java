package com.jools.pat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 14:50
 * @description: TODO
 */
public class PAT1053Demo {
}


class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line01 = br.readLine().split("\\s+");
        int N = Integer.parseInt(line01[0]);    // 总节点数目
        int M = Integer.parseInt(line01[1]);    // 非叶子节点数目
        int W = Integer.parseInt(line01[2]);    // 目标权值和

        // 存储各个节点序号和其对应的权值
        String[] line02 = br.readLine().split("\\s+");
        int[] weights = new int[line02.length];
        for (int i = 0; i < line02.length; i++) {
            weights[i] = Integer.parseInt(line02[i]);
        }
        System.out.println("各个节点的权重:" + Arrays.toString(weights));


        // 存储节点序号和节点实例映射
        Map<String, Node> nodes = new HashMap<>();

        // 构造根节点
        String[] line03 = br.readLine().split("\\s+");
        Node root = new Node(line03[0], weights[0]);
        nodes.put(root.no, root);
        System.out.println("Root Node:" + root);

        int nums = Integer.parseInt(line03[1]);    // 叶子节点数目
        String no;    //节点序号
        int weight;    // 节点权重
        Node child;    // 子节点

        for (int i = 2; i < line03.length; i++) {
            no = line03[i];
            weight = weights[Integer.parseInt(no)];
            child = new Node(no, weight);
            System.out.println("Add children:" + child);
            root.addChild(child);
            nodes.put(no, child);
        }

        // 层序遍历构建多叉树
        Node curr;
        for (int i = 0; i < M - 1; i++) {
            String[] next = br.readLine().split("\\s+");
            curr = nodes.get(next[0]);    // 获取当前层构造的节点
            System.out.println("Parent:" + curr);
            nums = Integer.parseInt(next[1]);
            for (int j = 2; j < next.length; j++) {
                no = next[j];
                weight = weights[Integer.parseInt(no)];
                child = new Node(no, weight);
                // 可能当前不知道其父节点
                if (curr != null) {
                    curr.addChild(child);
                    System.out.println("Add children:" + child);
                }
                nodes.put(no, child);
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);    // 根节点开始
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, W - root.val, path, res);

        //按照递减顺序
        Collections.sort(res, (l1, l2) -> {
            int size1 = l1.size();
            int size2 = l2.size();
            int p1 = 0, p2 = 0;
            while (p1 < size1 && p2 < size2) {
                if (!l1.get(p1).equals(l2.get(p2))) {
                    return l2.get(p2).compareTo(l2.get(p2));
                }
                p1++;
                p2++;
            }
            return 0;
        });

        // 输出
        StringBuilder sb;
        for (int i = 0; i < res.size(); i++) {
            List<Integer> ans = res.get(i);
            sb = new StringBuilder();
            for (int j = 0; j < ans.size(); j++) {
                sb.append(ans.get(j)).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    // 深度优先递归搜索路径
    private static void dfs(Node curr, int target,
                            List<Integer> path, List<List<Integer>> res) {
        if (curr.children.isEmpty()) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        List<Node> children = curr.children;
        for (int i = 0; i < children.size(); i++) {
            Node n = children.get(i);
            if (target - n.val < 0) {
                continue;
            }
            path.add(n.val);
            dfs(n, target - n.val, path, res);
            path.remove(path.size() - 1);
        }
    }
}

class Node {
    String no;
    int val;
    List<Node> children;    // 多叶子节点，存在多个孩子

    public Node(String no, int val) {
        this.no = no;
        this.val = val;
        this.children = new ArrayList<>();
    }

    public void addChild(Node c) {
        this.children.add(c);
    }

    public String toString() {
        return "Node:{ no=" + this.no + ", val=" + this.val + "}";
    }
}
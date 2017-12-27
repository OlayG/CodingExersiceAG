package com.example.admin.codingexersice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TreeActivity extends AppCompatActivity {

    private static String levelOrder;
    @BindView(R.id.node1)
    EditText node1;
    @BindView(R.id.node2)
    EditText node2;
    @BindView(R.id.node3)
    EditText node3;
    @BindView(R.id.node4)
    EditText node4;
    @BindView(R.id.node5)
    EditText node5;
    @BindView(R.id.results)
    TextView results;
    MyTree<Integer> root;

    public static <T> void printNodesLO(MyTree<T> root) {

        // null check
        if (root == null) {
            levelOrder = " Empty\n";
            return;
        }

        LevelOrderQueue<MyTree<T>> queue = new LevelOrderQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            processLevel(queue);
        }
    }

    private static <T> void processLevel(LevelOrderQueue<MyTree<T>> queue) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            MyTree<T> temp = queue.dequeue();
            levelOrder += temp.data + " ";
            queue.enqueue(temp.left);
            queue.enqueue(temp.right);
        }

        levelOrder += "\n";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.printResult)
    public void onViewClicked() {
        levelOrder = "This is a print out of the tree by level order \n\n";
        // regex string to check if value is a number
        String regex = "\\d+";

        Toast.makeText(this, "" + node1.toString().isEmpty(), Toast.LENGTH_SHORT).show();

        // Root Level
        // Checks if root is a number and is not null before proceeding
        if (node1.getText().toString().matches(regex) && node1.toString().isEmpty()) {

            // Adds user input in first node as root
            root = new MyTree<>(Integer.parseInt(node1.getText().toString()));

            // Level 1 LEFT
            if (node2.getText().toString().matches(regex)) {
                // Adds user input in second node as roots left child
                root.left = new MyTree<>(Integer.parseInt(node2.getText().toString()));

                // Level 2 LEFT
                if (node4.getText().toString().matches(regex)) {
                    root.left.left = new MyTree<>(Integer.parseInt(node4.getText().toString()));
                }
                // Level 2 RIGHT
                if (node5.getText().toString().matches(regex)) {
                    root.left.right = new MyTree<>(Integer.parseInt(node5.getText().toString()));
                }
            }

            // Level 1 RIGHT
            if (node3.getText().toString().matches(regex)) {
                // Adds user input in third node as roots right child
                root.right = new MyTree<>(Integer.parseInt(node3.getText().toString()));
            }

            printNodesLO(root);
            results.setText(levelOrder);
        } else {
            results.setText("Root is Null!! Must provide atleast the root to proceed");
            Toast.makeText(this, "Root is Null", Toast.LENGTH_SHORT).show();
        }

    }
}


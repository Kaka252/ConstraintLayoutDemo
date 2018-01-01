# ConstraintLayout功能和使用
ConstraintLayout是Google在2016年的I/O大会上推出一款新型布局方式。目的是为了解决由于布局嵌套过于复杂而带来的页面渲染性能问题。接下来，通过几个例子来分析ConstraintLayout都带来了哪些优势，以及我们为什么要使用它。

## 1. 引入
ConstraintLayout直到现在依然在开发和维护过程中，并且现在已经是稳定版，通过引入如下代码即可对该布局进行使用：
```
implementation 'com.android.support.constraint:constraint-layout:1.0.2'
```

# ConstraintLayout功能和使用
ConstraintLayout是Google在2016年的I/O大会上推出一款新型布局方式。目的是为了解决由于布局嵌套过于复杂而带来的页面渲染性能问题。接下来，通过几个例子来分析ConstraintLayout都带来了哪些优势，以及我们为什么要使用它。

## 1. 引入
ConstraintLayout直到现在依然在开发和维护过程中，并且现在已经是稳定版，通过引入如下代码即可对该布局进行使用：
```
implementation 'com.android.support.constraint:constraint-layout:1.0.2'
```
## 2. ConstraintLayout是个啥
那么，在使用之前，还是有必要先简单认识一下我们将要使用的这个布局到底是个啥。官方文档上是这么说的：
```
A ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way.
```
描述很直接，说的就是ConstraintLayout其实就是一个ViewGroup，可以灵活的摆放控件的位置和调整控件的大小。那么接下来就研究一下描述中提到的这个"灵活性"。
## 3. ConstraintLayout的属性
先简单了解一下我们使用这个布局要用到的属性，如下表所示：

属性
------------
layout_constraintLeft_toLeftOf
layout_constraintLeft_toRightOf
layout_constraintRight_toLeftOf
layout_constraintRight_toRightOf
layout_constraintTop_toTopOf
layout_constraintTop_toBottomOf
layout_constraintBottom_toTopOf
layout_constraintBottom_toBottomOf
layout_constraintBaseline_toBaselineOf
layout_constraintBaseline_creator
layout_constraintStart_toEndOf
layout_constraintStart_toStartOf
layout_constraintEnd_toStartOf
layout_constraintEnd_toEndOf
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
先简单了解一下我们使用这个布局要用到的一些基本方位属性，如下表所示：

属性 | 描述
------------ | -------------
layout_constraintLeft_toLeftOf | 把A的left side放在B的left side（左边对齐）
layout_constraintLeft_toRightOf | 把A的left side放在B的right side（左边相对右边对齐）
layout_constraintRight_toLeftOf | 把A的right side放在B的left side（右边相对左边对齐）
layout_constraintRight_toRightOf | 把A的right side放在B的right side（右边对齐）
layout_constraintTop_toTopOf | 把A的top side放在B的top side（顶部对齐）
layout_constraintTop_toBottomOf | 把A的top side放在B的bottom side（顶部相对底部对齐）
layout_constraintBottom_toTopOf | 把A的bottom side放在B的top side（底部相对顶部对齐）
layout_constraintBottom_toBottomOf | 把A的bottom side放在B的bottom side（底部对齐）
layout_constraintStart_toEndOf | 把A的start position放在B的end position（起始位置相对结束位置对齐）
layout_constraintStart_toStartOf | 把A的start position放在B的start position（起始位置对齐）
layout_constraintEnd_toStartOf | 把A的end position放在B的start position（结束位置相对起始位置对齐）
layout_constraintEnd_toEndOf | 把A的end position放在B的end position（结束位置对齐）
layout_constraintBaseline_toBaselineOf | 把A的bottom side放在B的top side（基准线对齐）
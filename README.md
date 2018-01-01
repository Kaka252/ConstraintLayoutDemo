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
## 3. ConstraintLayout的方位属性
先简单了解一下我们使用这个布局要用到的一些基本方位属性，如下表所示：

属性 | 描述
------------ | -------------
app:layout_constraintLeft_toLeftOf | 把A的left side放在B的left side（左边对齐）
app:layout_constraintLeft_toRightOf | 把A的left side放在B的right side（左边相对右边对齐）
app:layout_constraintRight_toLeftOf | 把A的right side放在B的left side（右边相对左边对齐）
app:layout_constraintRight_toRightOf | 把A的right side放在B的right side（右边对齐）
app:layout_constraintTop_toTopOf | 把A的top side放在B的top side（顶部对齐）
app:layout_constraintTop_toBottomOf | 把A的top side放在B的bottom side（顶部相对底部对齐）
app:layout_constraintBottom_toTopOf | 把A的bottom side放在B的top side（底部相对顶部对齐）
app:layout_constraintBottom_toBottomOf | 把A的bottom side放在B的bottom side（底部对齐）
app:layout_constraintStart_toEndOf | 把A的start position放在B的end position（起始位置相对结束位置对齐）
app:layout_constraintStart_toStartOf | 把A的start position放在B的start position（起始位置对齐）
app:layout_constraintEnd_toStartOf | 把A的end position放在B的start position（结束位置相对起始位置对齐）
app:layout_constraintEnd_toEndOf | 把A的end position放在B的end position（结束位置对齐）
app:layout_constraintBaseline_toBaselineOf | 把A的bottom side放在B的top side（基准线对齐）

注意：属性的命名空间是app。

一堆属性看下来，想必你也晕了吧，看个例子就一目了然了：
```
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btn_item_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="左上"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/btn_item_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="右上"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/btn_item_3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="左下"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent" />

    <Button
        android:id="@+id/btn_item_4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="右下"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toRightOf="parent" />

    <Button
        android:id="@+id/btn_item_5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="中间"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toRightOf="parent" />
</android.support.constraint.ConstraintLayout>
```
通过以上的这段布局，即可完成下图所示的基础方位布局的搭建。仔细观察，你可能会发现这不就是RelativeLayout里面的alignParentXXX吗？Definitely Yes。
![固定方位布局](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/positioning_views.png)

如果想根据控件和控件之间的相对位置进行摆放的话，那么可以参考如下的使用方式进行处理：
```
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <Button
        android:id="@+id/btn_text_A"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:text="text A"/>

    <Button
        android:id="@+id/btn_text_B"
        app:layout_constraintLeft_toRightOf="@+id/btn_text_A"
        app:layout_constraintBottom_toBottomOf="@+id/btn_text_A"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="text B"/>

    <Button
        android:id="@+id/btn_text_C"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="@id/btn_text_A"
        app:layout_constraintTop_toBottomOf="@+id/btn_text_A"
        android:text="text C"/>

    <Button
        android:id="@+id/btn_text_D"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toEndOf="@id/btn_text_C"
        app:layout_constraintTop_toBottomOf="@+id/btn_text_A"
        android:text="text D"/>

</android.support.constraint.ConstraintLayout>
```
布局的代码页很简单，就是把A控件作为参照位置，然后再根据A的位置来定位其他控件的相对位置。


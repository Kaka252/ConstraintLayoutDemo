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
![相对位置布局](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/device-2018-01-01-164744.png)

那么通过这两个例子，你会发现，RelativeLayout的相对位置的操作，ConstraintLayout也能轻易实现。

# 偏斜(Bias)
在使用LinearLayout的时候，我们通常会使用Gravity来将水平或者垂直排列的控件按照权重的分配进行排列。而在ConstraintLayout中，它提供了bias属性来对控件进行权重的分配。
```
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="text"
        app:layout_constraintHorizontal_bias="0.25"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent" />

</android.support.constraint.ConstraintLayout>
```
以上代码我们可以简单的看出，当一个控件被约束在屏幕的左侧，又被约束在屏幕的右侧，结果这个控件显示在了中间的位置，为什么？
(1) 当使用了bias属性并设置了0.25的偏移量之后，我们发现控件在水平方向上向左偏移了屏幕宽度的1/4距离
(2) 如果我们把偏移值改成0.75，我们可以看到控件在水平方向上向右偏移了1/4的距离。

那么我们可以看出一点就是，当一个控件在被约束的前提下，它的默认偏移量是0.5。

属性 | 描述
------------ | -------------
app:layout_constraintHorizontal_bias | 水平方向偏移系数
app:layout_constraintVertical_bias | 垂直方向偏移系数

当然我们不只可以针对水平方向对控件进行偏移，同样也可以在垂直方向上进行偏移。

# GONE不是真的GONE
我们在使用RelativeLayout铺页面的时候，经常会碰到这么一种逻辑，当某个数据为空的时候，该数据所绑定的控件则GONE掉。那么这样会出现这样的问题，假如有三个控件A，B，C垂直排列，B在A的下方，C在B的下方，当B隐藏(GONE)掉了之后，由于C对于A并没有依赖关系，所以会导致页面错乱。这个问题ConstraintLayout给出了很好的解决方案。
当在ConstraintLayout中，若一个控件隐藏(GONE)之后，他会变成一个点，因此对于把该控件作为参考控件的其他控件依然具有约束作用。官方的文档也给出了答案。

```
For the layout pass, their dimension will be considered as if zero (basically, they will be resolved to a point).

If they have constraints to other widgets they will still be respected, but any margins will be as if equals to zero.
```
当这个控件隐藏之后，我们还可以参照这个隐藏的控件对其他控件设置边距的属性。

属性 | 描述
------------ | -------------
app:layout_goneMarginLeft | 隐藏控件左边距
app:layout_goneMarginRight | 隐藏控件右边距
app:layout_goneMarginTop | 隐藏控件顶部边距
app:layout_goneMarginBottom | 隐藏控件底部边距
app:layout_goneMarginStart | 隐藏控件起始边距
app:layout_goneMarginEnd | 隐藏控件结束边距

# 复杂布局的灵药：Chain属性
Chain 链是一种特殊的约束让多个 chain 链连接的 Views 能够平分剩余空间位置。在 Android 传统布局特性里面最相似的应该是 LinearLayout 中的权重比 weight ，但 Chains 链能做到的远远不止权重比 weight 的功能。如果要实现一个控件之间的链结构，我们可以将这些控件之间建立起互相的约束关系，并在这些关系的基础上选择创建水平方向的链还是垂直方向的链。

在本例的工程中，我实现了控件在水平方向上的链结构，并实现了关于Chain属性的几种形态，如下图所示：

![Chain属性图解](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/chain_types.png)

### 0. 属性参数和值
对于Chain属性的种类来说，一共两种：水平方向(Horizontal)和垂直方向(Vertical)。

属性 | 描述
------------ | -------------
app:layout_constraintHorizontal_chainStyle | 水平方向上的Chain
app:layout_constraintVertical_chainStyle | 垂直方向上的Chain

对于Chain属性的模式来说，一共三种：展开(spread)，内部展开(spread_inside)和包裹(packed)。

Chain模式 | 描述
------------ | -------------
spread | 展开
spread_inside | 内部展开
packed | 包裹

### 1. Spread链模式
spread模式会把空间平均分配开来，每个View占有各自的平分空间。它是Chain属性的默认模式。

![Spread模式](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/chain_spread.png)

当使用了这个模式的时候，我们还可以配合weight属性设置spread的权重，在设置权重的时候，我们需要将控件的width或者height设置成0dp，并设置layout_constraintHorizontal_weight或者layout_constraintVertical_weight的值：

权重属性 | 描述
------------ | -------------
app:layout_constraintVertical_weight | 垂直方向的控件权重
app:layout_constraintHorizontal_weight | 水平方向的控件权重

通过权重的设置，如图：

![Spread with weight](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/chain_spread_with_weight.png)

### 2. Spread Inside链模式
spread inside模式是在Spread的基础上，把两边最边缘的两个View到外向父组件边缘的距离去除，然后让剩余的Views在剩余的空间内部平分空间。

![Spread Inside模式](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/chain_spread_inside.png)

### 3. Packed链模式
packed模式很直观，它将所有Views聚拢在一起，控件和控件之间不留间隙，并将聚拢之后的Views居中显示。

![Packed模式](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/chain_packed.png)

当我们使用了Packed模式了之后，我们还可以通过bias参数对聚拢在一起的Views进行位置的调整。

![Packed with bias](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/chain_packed_with_bias.png)

### 4. XML中设置Chain属性
设置Chain属性需要保证两个条件：

1. 定义chain链的约束条件
2. 在Chain的第一个组件上设置chainStyle。

```
    <android.support.constraint.ConstraintLayout
        android:id="@+id/cl_chain_spread"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/tv_chain_1"
            android:layout_width="wrap_content"
            android:layout_height="50dp"
            android:background="@color/colorAccent"
            android:gravity="center_vertical|left"
            android:singleLine="true"
            android:text="text 1"
            android:textColor="@android:color/white"
            app:layout_constraintHorizontal_chainStyle="spread"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toLeftOf="@+id/tv_chain_2" />

        <TextView
            android:id="@+id/tv_chain_2"
            android:layout_width="wrap_content"
            android:layout_height="50dp"
            android:background="@color/colorPrimary"
            android:gravity="center"
            android:singleLine="true"
            android:text="text 2"
            android:textColor="@android:color/white"
            app:layout_constraintLeft_toRightOf="@+id/tv_chain_1"
            app:layout_constraintRight_toLeftOf="@+id/tv_chain_3" />

        <TextView
            android:id="@+id/tv_chain_3"
            android:layout_width="wrap_content"
            android:layout_height="50dp"
            android:background="@android:color/black"
            android:gravity="center"
            android:singleLine="true"
            android:text="text 3"
            android:textColor="@android:color/white"
            app:layout_constraintLeft_toRightOf="@+id/tv_chain_2"
            app:layout_constraintRight_toRightOf="parent" />

    </android.support.constraint.ConstraintLayout>
```
定义chain链就是对于同一对锚点设置方向相反的约束条件，比如tv_chain_1中设置了app:layout_constraintRight_toLeftOf="@+id/tv_chain_2"，tv_chain_2中也设置了app:layout_constraintLeft_toRightOf="@+id/tv_chain_1"。正如这样，这两个控件之间形成了彼此约束的关系，也即形成链。

# GuideLine的使用
参照线 guideline 提供了视觉上的参照用于 Views 的对齐，而且不会在运行的时候显示。

### Guideline是什么
通过GuideLine的内部实现，我们发现GuideLine的实现方式很简单：
1. Guideline就是一个View
2. 它不会渲染任何东西，因为draw()方法中无具体实现，并且在onMeasure()方法中固定了它自己的宽高都为0。
3. 在初始的情况下，它的可见性被固定成了View.GONE。

但是由于它在layout布局过程中会占据一个位置，因此其他组件可以以它为参照物进行对齐。

### Guideline的使用
我们可以在水平方向或者垂直方向进行guideline的创建。

方向 | 描述
------------ | -------------
android:orientation | 方向

创建了GuideLine之后，我们可以设置参考线的初始位置：

权重属性 | 描述
------------ | -------------
app:layout_constraintGuide_begin | 以View的起始位置为参照物，水平或垂直方向上边界(dp)
app:layout_constraintGuide_end | 以View的结束位置为参照物，水平或垂直方向上边界(dp)
app:layout_constraintGuide_percent | 水平或垂直方向上的百分比(float ratio 0.0f - 1.0f)

```
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:fresco="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp">

    <android.support.constraint.Guideline
        android:id="@+id/guide_line"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.5" />

    <com.facebook.drawee.view.SimpleDraweeView
        android:id="@+id/iv_avatar"
        android:layout_width="50dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintDimensionRatio="H,1:1"
        app:layout_constraintTop_toTopOf="parent"
        fresco:fadeDuration="250" />

    <TextView
        android:id="@+id/tv_title"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:layout_marginLeft="15dp"
        android:singleLine="true"
        android:textColor="@color/color_484848"
        app:layout_constraintBottom_toTopOf="@+id/guide_line"
        app:layout_constraintLeft_toRightOf="@id/iv_avatar"
        app:layout_constraintRight_toLeftOf="@+id/iv_arrow"
        tools:text="sdfsdfsfsdfsdf" />

    <TextView
        android:id="@+id/tv_desc"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:singleLine="true"
        android:textColor="@color/color_484848"
        app:layout_constraintLeft_toLeftOf="@+id/tv_title"
        app:layout_constraintRight_toLeftOf="@+id/iv_arrow"
        app:layout_constraintTop_toBottomOf="@+id/guide_line"
        tools:text="sdfsdfsfsdfsdf" />

    <ImageView
        android:id="@+id/iv_arrow"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_arrow_gray"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```

在上面的例子中，我实现了列表中的一个item，我希望所有的控件在垂直方向上保持居中显示。

![guideline示例](https://github.com/Kaka252/ConstraintLayoutDemo/blob/master/screenshots/guide_line_practise_sample.png)

# 总结

使用ConstraintLayout构建页面，可以大大的减少页面布局的层级，让页面更加扁平化，也让页面的渲染速度加快。缺点是在建立控件和控件之间的约束时，代码略显啰嗦。
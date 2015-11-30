# RotateViewPage
ViewPager在切换的时候，页面会有一定角度的切换。
#使用方法
1.ViewPager本身的设置：

```
<android.support.v4.view.ViewPager
    android:id="@+id/pager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:clipToPadding="false"
    android:paddingLeft="100px"
    android:paddingRight="100px"/>

```
为它设置左右padding，然后clipToPadding = false，这样就可以看见和边上page交互转动的过程了。

2.将page之间的margin设置为负值，这样就可以在当前页面看见左右的page了。然后就是将ZoomOutPageTransformer设置为ViewPager的切换动画：

```
mPager.setPageMargin(-50);
mPager.setPageTransformer(true,new ZoomOutPageTransformer(mPager));
```

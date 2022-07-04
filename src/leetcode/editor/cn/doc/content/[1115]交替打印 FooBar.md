<p>给你一个类：</p>

<pre>
class FooBar {
  public void foo() {
&nbsp; &nbsp; for (int i = 0; i &lt; n; i++) {
&nbsp; &nbsp; &nbsp; print("foo");
&nbsp;   }
  }

  public void bar() {
&nbsp; &nbsp; for (int i = 0; i &lt; n; i++) {
&nbsp; &nbsp; &nbsp; print("bar");
&nbsp; &nbsp; }
  }
}
</pre>

<p>两个不同的线程将会共用一个 <code>FooBar</code>&nbsp;实例：</p>

<ul>
	<li>线程 A 将会调用&nbsp;<code>foo()</code>&nbsp;方法，而</li>
	<li>线程 B 将会调用&nbsp;<code>bar()</code>&nbsp;方法</li>
</ul>

<p>请设计修改程序，以确保 <code>"foobar"</code> 被输出 <code>n</code> 次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>"foobar"
<strong>解释：</strong>这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>"foobarfoobar"
<strong>解释：</strong>"foobar" 将被输出两次。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>
<div><div>Related Topics</div><div><li>多线程</li></div></div><br><div><li>👍 164</li><li>👎 0</li></div>
# MyAppMeihualiScan
超快扫描二维码
本库依赖
compile 'com.github.meihuali:MyAppMeihualiScan:v1.1.2'

//本库还需要加入 仓库·

maven { url 'https://jitpack.io' } 

如果你已经加入了仓库了·就不需要在加入仓库了·

具体用法那就他妈的 超简单了·一句话搞定·

点击按钮·事件·直接掉这句话·就完事了·6.0权限不用担心

我们只追求扫描速度以及精准率·本库1米开外的距离都是秒扫

让你手机都还没拿好的情况就给你扫掉了·

我们要的就是飞一般的感觉

详细用法：

在点击事件中 


  Intent intent = new Intent(getApplicationContext(), CaptureActivity.class);
  
                startActivityForResult(intent,resultcode);
                
                
然后重写

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String result = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(),"测试结果 "+result ,Toast.LENGTH_SHORT).show();
        }
    }

package com.example.chartest;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lineChart = findViewById(R.id.linechart);
        setChart();
    }

    private void setChart(){
        float[] today = new float[] {
                -1f ,   -0.6f ,    -0.605f ,  -1f ,  -0.573f ,  1.009f ,
                5f ,    7.51f ,    22.637f ,  47f ,  43.927f ,  52.98f ,
                56.591f ,   88f ,  96.236f ,  59.722f ,  86f ,  70.029f ,
                50.521f ,   81f ,  84.996f ,  133.625f , 133f , 149.174f ,
                243.996f ,  336.891f , 235f , 291.4f ,   386f , 386.511f ,
                401.529f ,  321f , 347.916f , 266.802f , 522f , 522.065f ,
                305.735f ,  399.764f , 417f , 267.151f , 419.587f , 174f ,
                202.781f ,  168f , 334.205f , 693.414f , 499f , 425.094f ,
                319.545f ,  284.769f , 271f , 345.056f , 767.463f , 578f ,
                801.516f ,  524f , 722.201f , 659.075f , 439f , 440.058f ,
                540.768f ,  289.908f , 318f , 499.805f , 426.53f ,  889f ,
                809.674f ,  466f , 437.184f ,
        };
        String[] ttime = new String[] {
                "05:10:00", "05:14:00",    "05:21:00",    "05:25:00",    "05:28:00",
                "05:35:00", "05:40:00",    "05:42:00",    "05:49:00",    "05:55:00",
                "05:56:00", "06:00:00",    "06:07:00",    "06:10:00",    "06:14:00",
                "06:21:00", "06:25:00",    "06:28:00",    "06:35:00",    "06:40:00",
                "06:42:00", "06:49:00",    "06:55:00",    "06:56:00",    "07:00:00",
                "07:07:00", "07:10:00",    "07:14:00",    "07:25:00",    "07:28:00",
                "07:35:00", "07:40:00",    "07:42:00",    "07:49:00",    "07:55:00",
                "07:56:00", "08:00:00",    "08:07:00",    "08:10:00",    "08:14:00",
                "08:21:00", "08:25:00",    "08:28:00",    "08:40:00",    "08:42:00",
                "08:49:00", "08:55:00",    "08:56:00",    "09:00:00",    "09:07:00",
                "09:10:00", "09:14:00",    "09:21:00",    "09:25:00",    "09:28:00",
                "09:40:00", "09:42:00",    "09:49:00",    "09:55:00",    "09:56:00",
                "10:00:00", "10:07:00",    "10:10:00",    "10:14:00",    "10:21:00",
                "10:25:00", "10:28:00",    "10:40:00",    "10:42:00",
        };


        float[] yestday = new float[] {
                -0.605f,    -1f,   -0.644f,   -0.79f,    1f,    2.418f,    9.619f,
                -1f,    -0.605f,   31.422f,   70f,   88.467f,   114.034f,
                125f,   135.506f,  167.897f,  178f,  185.211f,  212.186f,
                234f,   239.55f,   289f,  292.79f,   309.764f,  339.387f,
                347f,   359.329f,  387.155f,  403f,  406.666f,  431.498f,
                450f,   456.219f,  475.759f,  492f,  500.406f,  514.65f,
                494.397f,   568f,  599.791f,  529.451f,  623f,  574.879f,
                451f,   710.992f,  466.529f,  181f,  395.874f,  800.555f,
                798.48f,    790f,  812.796f,  660.98f,   327f,  248.581f,
                857f,   380.615f,  855.447f,  543f,  792.96f,   445.751f,
                334.438f,   849f,  878.799f,  682.834f,  830f,  889.564f,
                621f,   333.23f,   861.233f,  688f,  534.881f,  311.442f,
                420.116f,   917f,  914.388f,  343.475f,  324f,  359.745f,
                351f,   586.546f,  920.492f,  322f,  317.376f,  785.197f,
                871.612f,   823f,  841.094f,  891.736f,  815f,  793.277f,
                796.103f,   871f,  859.106f,  799.918f,  807f,  794.501f,
                785.599f,   779.081f,  776f,  786.822f,  785.253f,  766f,
                759.301f,   744.986f,  712f,  715.56f,   736.003f,  692f,
                695.517f,   719.334f,  693.748f,  303f,  277.091f,  690.293f,
                667f,   656.294f,  629f,  613.782f,  590.205f,  505f,  530.211f,
                442.603f,   541.195f,  532f,  525.26f,   536.203f,  499f,
                495.619f,   466.811f,  444f,  440.942f,  415.168f,  393f,
                391.487f,   380.142f,  352.016f,  343f,  325.009f,  296.689f,
                284f,   272.746f,  245.029f,  230f,  208.739f,  200.19f,
                177f,   171.299f,  168.593f,  152.167f,  146f,  138.774f,
                117.566f,   105f,  101.983f,  85.586f,   75f,   71.435f,
                61.343f,    63f,   61.183f,   50.677f,   42.078f,   42f,
                38.584f,    34.568f,   31f,   29.094f,   10.243f,   5f,
                3.669f, -0.789f,   -2f,   -1.915f };


        String[] ytime = new String[] {
                "05:07:00", "05:10:00",    "05:14:00",    "05:21:00",    "05:25:00",
                "05:28:00", "05:35:00",    "05:40:00",    "05:42:00",    "05:49:00",
                "05:55:00", "06:00:00",    "06:07:00",    "06:10:00",    "06:14:00",
                "06:21:00", "06:25:00",    "06:28:00",    "06:35:00",    "06:40:00",
                "06:42:00", "06:55:00",    "06:56:00",    "07:00:00",    "07:07:00",
                "07:10:00", "07:14:00",    "07:21:00",    "07:25:00",    "07:28:00",
                "07:35:00", "07:40:00",    "07:42:00",    "07:49:00",    "07:55:00",
                "07:56:00", "08:00:00",    "08:07:00",    "08:10:00",    "08:14:00",
                "08:21:00", "08:25:00",    "08:28:00",    "08:40:00",    "08:42:00",
                "08:49:00", "08:55:00",    "08:56:00",    "09:00:00",    "09:07:00",
                "09:10:00", "09:14:00",    "09:21:00",    "09:25:00",    "09:28:00",
                "09:40:00", "09:42:00",    "09:49:00",    "09:55:00",    "09:56:00",
                "10:00:00", "10:07:00",    "10:10:00",    "10:14:00",    "10:21:00",
                "10:25:00", "10:28:00",    "10:40:00",    "10:42:00",    "10:49:00",
                "10:55:00", "10:56:00",    "11:00:00",    "11:07:00",    "11:10:00",
                "11:14:00", "11:21:00",    "11:25:00",    "11:28:00",    "11:40:00",
                "11:42:00", "11:49:00",    "11:55:00",    "11:56:00",    "12:00:00",
                "12:07:00", "12:10:00",    "12:14:00",    "12:21:00",    "12:25:00",
                "12:28:00", "12:35:00",    "12:40:00",    "12:42:00",    "12:49:00",
                "12:55:00", "12:56:00",    "13:00:00",    "13:07:00",    "13:10:00",
                "13:14:00", "13:21:00",    "13:25:00",    "13:28:00",    "13:35:00",
                "13:40:00", "13:42:00",    "13:49:00",    "13:55:00",    "13:56:00",
                "14:00:00", "14:07:00",    "14:10:00",    "14:14:00",    "14:21:00",
                "14:25:00", "14:28:00",    "14:40:00",    "14:42:00",    "14:49:00",
                "14:55:00", "14:56:00",    "15:00:00",    "15:07:00",    "15:10:00",
                "15:14:00", "15:21:00",    "15:25:00",    "15:28:00",    "15:35:00",
                "15:40:00", "15:42:00",    "15:49:00",    "15:55:00",    "15:56:00",
                "16:00:00", "16:07:00",    "16:10:00",    "16:14:00",    "16:21:00",
                "16:25:00", "16:28:00",    "16:35:00",    "16:40:00",    "16:42:00",
                "16:49:00", "16:55:00",    "16:56:00",    "17:00:00",    "17:07:00",
                "17:10:00", "17:14:00",    "17:21:00",    "17:25:00",    "17:28:00",
                "17:35:00", "17:40:00",    "17:42:00",    "17:49:00",    "17:55:00",
                "17:56:00", "18:00:00",    "18:07:00",    "18:10:00",    "18:14:00",
                "18:21:00", "18:25:00",    "18:28:00",    "18:35:00",    "18:40:00",
                "18:42:00", "18:49:00",    "18:55:00",    "18:56:00" };


        // 初始化數據
        List<Entry> entries1 = new ArrayList<>();
        List<Entry> entries2 = new ArrayList<>();
        for(int i = 0; i < today.length; i++){
            entries1.add(new Entry(getTimeMillis(ttime[i]), today[i]));
        }
        for(int i = 0; i < yestday.length; i++) {
            entries2.add(new Entry(getTimeMillis(ytime[i]), yestday[i]));
        }


        // 創建數據集
        LineDataSet dataSet1 = new LineDataSet(entries1, "今日");
        dataSet1.setDrawCircles(false);  //不顯示相應座標點的小圓圈(預設顯示)
        dataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER); // 設定線條樣式
        dataSet1.setColor(Color.parseColor("#EE82EE")); // 設定線條顏色
        dataSet1.setValueTextColor(Color.WHITE); // 設置文字顏色為白色


        LineDataSet dataSet2 = new LineDataSet(entries2, "昨日");
        dataSet2.setDrawCircles(false);  //不顯示相應座標點的小圓圈(預設顯示)
        dataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER); // 設定線條樣式
        dataSet2.setColor(Color.parseColor("#F0E68C")); // 設定線條顏色
        dataSet2.setValueTextColor(Color.WHITE); // 設置文字顏色為白色


        // lineData.setDrawValues(false);//不要再點上顯示值


        // 設置數據
        LineData lineData = new LineData(dataSet1, dataSet2);
        lineChart.setData(lineData);


        // 設置 X 軸時間格式
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            private final SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);


            @Override
            public String getFormattedValue(float value) {
                return mFormat.format(new Date((long) value));
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(3600000f); // 每小時的間隔
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.WHITE);


        // 設置 Y 軸文字顏色為白色
        lineChart.getAxisLeft().setTextColor(Color.WHITE);
        lineChart.getAxisRight().setTextColor(Color.WHITE);


        // 設置圖例文字顏色為白色
        lineChart.getLegend().setTextColor(Color.WHITE);


        // 應用自定義的 MarkerView
        CustomMarkerView markerView = new CustomMarkerView(this, R.layout.marker_view);
        lineChart.setMarker(markerView);


        //MyMarkerView markerView =  new MyMarkerView(this, R.layout.marker_view);
        //lineChart.setMarker(markerView);


        // 刷新圖表
        lineChart.invalidate();
    }

    private long getTimeMillis(String timeStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
            Date date = sdf.parse(timeStr);
            return date != null ? date.getTime() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
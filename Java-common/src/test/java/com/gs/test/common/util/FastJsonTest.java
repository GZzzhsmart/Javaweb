package com.gs.test.common.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangGenshen on 7/21/15.
 */
public class FastJsonTest {

    @Test
    public void testFastJson() {
        HighCharts highCharts = new HighCharts();
        HighCharts.Chart chart = highCharts.new Chart();
        chart.setType("column");
        HighCharts.Title title = highCharts.new Title();
        title.setText("this is title");
        List<HighCharts.Series> seriesList = new ArrayList<HighCharts.Series>();
        HighCharts.Series series = highCharts.new Series();
        series.setName("Jane");
        List<Integer> data = new ArrayList<Integer>();
        data.add(100);
        data.add(200);
        data.add(300);
        series.setData(data);
        seriesList.add(series);
        highCharts.setChart(chart);
        highCharts.setTitle(title);
        highCharts.setSeries(seriesList);
        System.out.println(JSON.toJSON(highCharts));
    }

    @Test
    public void testMapJson() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        System.out.println(JSON.toJSONString(map));
    }

}

class HighCharts {
    public class Chart {
        private String type;
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
    }
    public class Title {
        private String text;
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
    }
    public class Series<T extends Object> {
        private String name;
        private List<T> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<T> getData() {
            return data;
        }

        public void setData(List<T> data) {
            this.data = data;
        }
    }

    private Chart chart;
    private Title title;
    private List<Series> series;

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}

import { useEffect, useState } from 'react';
import axios from 'axios';
import Chart from 'react-apexcharts';
import { BASE_URL } from 'utils/requests';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/math-round';

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[];
};

function BarChart() {

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [{
            name: '',
            data: []
        }]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`)
            .then(response => {
                const data = response.data as SaleSuccess[];
                const dataLabels = data.map(sale => sale.sellerName);
                const dataSeries = data.map(sale => getPercent(sale.deals, sale.visited));

                setChartData({
                    labels: {
                        categories: dataLabels
                    },
                    series: [{
                        name: '% sucesso',
                        data: dataSeries
                    }]
                });
            })
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

function getPercent(deals: number, visited: number) {
    return round(100.0 * deals / visited, 1);
}

export default BarChart;
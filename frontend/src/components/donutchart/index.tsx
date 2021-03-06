import Chart from 'react-apexcharts';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import { SaleSum } from 'types/sale';
import { useEffect, useState } from 'react';

type ChartData = {
    labels: string[];
    series: number[];
}

function DonutChart() {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(response => {
                const data = response.data as SaleSum[];
                const dataLabels = data.map(sale => sale.sellerName);
                const dataSeries = data.map(sale => sale.sum);

                setChartData({ labels: dataLabels, series: dataSeries });
            })
    }, []);



    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;
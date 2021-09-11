import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
   labels: string[];//um array de strings
   series: number[];
}

function DonutChart() {

   const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

   useEffect(() => {
      //Requisição para o backend
      axios.get(`${BASE_URL}/sales/amount-by-seller`)
         .then((response) => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            setChartData({ labels: myLabels, series: mySeries });
            // response.data -> acessa apenas os dados retornados, sem demais campos como o numero da página, qtd de itens etc
         })
   }, []);



   // const mockData = {
   //    series: [477138, 499928, 444867, 220426, 473088],
   //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
   // }

   const options = {
      legend: {
         show: true
      }
   }

   return (
      <div>
         <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="250"
         />
      </div>
   );
}

export default DonutChart;
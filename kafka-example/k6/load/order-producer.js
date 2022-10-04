import {URL} from 'https://jslib.k6.io/url/1.0.0/index.js';
import http from 'k6/http';
import {check, sleep} from 'k6';
import {Rate} from 'k6/metrics';
import { writer, produce, reader, consume, createTopic } from 'k6/x/kafka';

// config
const bootstrapServers = ['kafka:9092'];
const kafkaTopic = 'dev.asterisk.order.json';
const BASE_URL = 'http://localhost:8084'

export let errorRate = new Rate('errors')

// producer and consumer
const producer = writer(bootstrapServers, kafkaTopic);
const consumer = reader(bootstrapServers, kafkaTopic);

// create topics
createTopic(bootstrapServers[0], kafkaTopic);

export default function () {
    createOrder()
}

// target functions
function createOrder() {
    let index = getRandomInt();
    const payload = JSON.stringify({
        'userId': 'Jungho' + index,
        "orderName": "교촌치킨" + index,
        "quantity": index.toString(),
        "price": index.toString()
    })

    const url = new URL(`${BASE_URL}/orders`)
    const response = http.post(url.toString(), payload)

    const success = check(response, {
        'Order creation has been successfully completed': (res) => res.status === 200
    });
    errorRate.add(!success)
    // sleep(1)
}

/*
export default function () {
    const messages = [
        {
            key: JSON.stringify({
                correlationId: 'test-id-sql-' + getRandomInt(),
            }),
            value: JSON.stringify({
                title: 'Load Testing SQL Databases with k6',
                url: 'https://k6.io/blog/load-testing-sql-databases-with-k6/',
                locale: 'en',
            }),
        },
    ];

    const error = produce(producer, messages);
    check(error, {
        'is sent': (err) => err === undefined,
    });
}
 */

function getRandomInt(max = 1000) {
    return Math.floor(Math.random() * max + 1);
}


/*
export let errorRate = new Rate('errors')

export let options = {
    stages: [
        // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
        {duration: '1m', target: '100'}, // ramp up
        {duration: '3m', target: '500'}, // ramp up
        {duration: '5m', target: '1000'}, // stay
        {duration: '3m', target: '500'}, // ramp down
        {duration: '10s', target: 0}, // ramp down
    ],
    thresholds: {
        checks: ['rage>0.99'],
    }
}
 */
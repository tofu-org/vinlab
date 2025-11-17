import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '30s', target: 20 },
    { duration: '1m', target: 50 },
  ],
};

export default function () {
  const response = http.get('https://literate-spork-wrj6v7jgwrrh97qv-8080.app.github.dev/');
  check(response, { 'status is 200': (r) => r.status === 200 });
  sleep(1);
}

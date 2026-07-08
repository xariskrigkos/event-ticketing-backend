import http from 'k6/http';
import { check } from 'k6';

export const options = {
    vus: 100,          // 100 virtual users
    iterations: 100    // Each sends one request
};

const payload = JSON.stringify({
    userId: "USER-001",
    eventId: "EVENT-LOCK-001",
    capacity: 1
});

const params = {
    headers: {
        'Content-Type': 'application/json'
    }
};

export default function () {
    const res = http.post(
        'http://localhost:8080/reservations',
        payload,
        params
    );

    console.log(`Status: ${res.status}`);

    if(res.status === 400){
        console.log("400 BODY:");
        console.log(res.body);
    }

    check(res, {
        'Created or Conflict': (r) => r.status === 201 || r.status === 409
    });
}
from locust import HttpUser, task, between

class WebsiteUser(HttpUser):
    wait_time = between(0.1, 0.3)
    
    @task
    def load_test(self):
        with self.client.get("/", catch_response=True) as response:
            if response.status_code < 400:
                response.success()
            else:
                response.failure(f"Status: {response.status_code}")

async function login(){
  const email = document.getElementById('email').value.trim();
  const password = document.getElementById('password').value;
  const res = await fetch('/api/auth/login', {
    method:'POST', headers:{'Content-Type':'application/json'},
    body: JSON.stringify({ email, password })
  });
  const out = document.getElementById('msg');
  if(res.ok){
    const data = await res.json();
    out.textContent = 'Login success: ' + data.name + ' (' + data.role + ')';
    setTimeout(() => location.href='/index.html', 800);
  } else {
    out.textContent = 'Invalid email or password';
  }
}

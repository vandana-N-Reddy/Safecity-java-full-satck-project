async function register(){
  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const password = document.getElementById('password').value;
  const role = document.getElementById('role').value;

  const res = await fetch('/api/auth/register', {
    method:'POST', headers:{'Content-Type':'application/json'},
    body: JSON.stringify({ name, email, password, role })
  });
  const out = document.getElementById('msg');
  if(res.ok){
    out.textContent = 'Registered successfully. Please login.';
    setTimeout(() => location.href='/login.html', 800);
  } else {
    const data = await res.json().catch(()=>({message:"ERROR"}));
    out.textContent = data.message === 'EMAIL_EXISTS' ? 'Email already registered' : 'Registration failed';
  }
}

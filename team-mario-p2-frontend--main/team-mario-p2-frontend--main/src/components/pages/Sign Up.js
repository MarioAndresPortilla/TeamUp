//Sign up page
//form with full name, email, user, pass, confirm pass, links to login page if already signed up
import SignUpButton from '../page elements/SignUpButton';
export default function SignUp() {
    return (
        <section class="general" id="signup">
      <div class="wrapper" id="wrapper">
        <div class="container">
            <div class="tabs">
                <ul>
                  <li class="sign_in_li">Sign Up</li>
                </ul>
            </div>
            <div class="input_field">
                <input type="text" placeholder="Full Name" class="input" id="fullnamefield"/>
            </div>
            <div class="input_field">
                <input type="text" placeholder="E-mail" class="input" id="emailfield" />
            </div>
            <div class="input_field">
                <input type="text" placeholder="Username" class="input" id="usernamefield" />
            </div>
            <div class="input_field">
                <input type="password" placeholder="Password" class="input" id="passwordfield"/>
            </div>
            <div class="input_field">
                <input type="password" placeholder="Confirm Password" class="input" id="confirmpasswordfield"/>
            </div>
            <SignUpButton />
            <li><a href="/login" class="next-page">Already a user?  Sign in</a></li>
        </div>
    </div>
    </section> 
    );
  }
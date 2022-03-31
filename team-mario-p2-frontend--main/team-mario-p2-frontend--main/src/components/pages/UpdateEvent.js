import ConfirmUpdateButton from "../page elements/ConfirmUpdateButton";
//Form to update events, taking information for each patch mapping
export default function UpdateEvent() {
    return (
        <section class="general" id="create">
        <div class="eventformwrapper" id="wrapper">
          <div class="container">
              <div class="tabs">
                  <ul>
                    <li class="sign_in_li">Update Event</li>
                  </ul>
              </div>
              <div class="input_field">
                  <input type="text" placeholder="Event Name" class="input" id="eventnamefield" required />
              </div>
              <div class="input_field">
                  <input type="text" placeholder="Sport" class="input" id="sportfield" required />
              </div>
              <div class="input_field" >
                  <select name="Skill level" placeholder="Skill level" class="input" id="skilllevelfield" required>
                      <option value = "" disabled selected hidden>Skill level</option>
                      <option value = "Beginner">Beginner</option>
                      <option value = "Intermediate">Intermediate</option>
                      <option value = "Advanced">Advanced</option>
                  </select>
              </div>
              <div class="input_field">
                  <input type="date" placeholder="Date" class="input" id="datefield" required />
              </div>
              <div class="input_field">
                  <input type="time" placeholder="Time" class="input" id="timefield" required />
              </div>
              <div class="input_field">
                  <input type="text" placeholder="Location" class="input" id="locationfield" required />
              </div>
              <ConfirmUpdateButton />
          </div>
      </div>
      </section> 
    );
  }
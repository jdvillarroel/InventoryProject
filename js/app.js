

const app = Vue.createApp({
  data() {
    return {
      // baseUrl: "http://localhost:8082/api/v1",
      baseUrl: "http://finalprojecttest-env.eba-t72vrei6.us-east-2.elasticbeanstalk.com/api/v1",
      // Array that contain all the items.
      items: [],

      // Add new item form variables.      
      addItemID: null,
      addItemName: "",
      addItemDescription: "",
      addItemQty: null,
      // Delete form variables.
      deleteItemID: null
    }
  },

  methods: {
    getItems() {
      fetch(this.baseUrl + "/getItems")
      .then(response => {
        // If server response code is OK get data.
        if (response.status == 200) {
          return response.json()
        } else {
          throw new Error("Response was not OK.")
        }        
      })
      .then(data => {
        console.log(data)

        // Assign the array of data received to the items array, so it can be rendered.
        this.items = data
      })
      .catch(err => console.log(err.message))
    },
    // Method to add a new item to the database.
    addItem() {
      let item = {
        itemID: this.addItemID,
        itemName: this.addItemName,
        itemDescription: this.addItemDescription,
        itemQty: this.addItemQty
      }
      // For debugging
      console.log(JSON.stringify(item))

      fetch(this.baseUrl + "/addItem", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(item)
      })
      .then(response => {
        if (response.status === 200) {
          this.addItemName = ""
          this.addItemDescription = ""
          this.addItemQty = null

          // return response.json()
        }
        else {
          throw new Error(`Error: ${response.status} - ${response.statusText}`)
        }
      })
      .then(() => {
        console.log('Item added successfully')

        // Reset form upon successful post request.
        this.$refs.addItemForm.reset()
      })
      .catch((error) => {
        console.log('Error:', error)
      })
    },

    deleteItem() {
      // Build endpoint to delete item by id in database.
      let url = `${this.baseUrl}/${this.deleteItemID}`

      fetch(url, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
          "mode": "no-cors"
        },
        body: {}
      })

      .then(response => {
        if (response.status === 200) {
          return response.json()
        } else {
          throw new Error(`Error: ${response.json()}`)
        }
      })
      .then(data => {
        console.log(data)
      })
      .catch(error => console.log(error))
    }
  }
})

// Insert Vue JS component into HTML element with the id="app".
app.mount("#app")
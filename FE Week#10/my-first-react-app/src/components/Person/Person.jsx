

const data =  {
        avatar: "https://i.pravatar.cc/150?img=50",
        name: "John Doe",
        phoneNumbers: [
          { name: "home", number: "123456789" },
          { name: "work", number: "987654321" }
        ],
        addresses: [
          { name: "home", address: "1234 Main St" },
          { name: "work", address: "5678 Main St" }
        ],
        emails: [
          { name: "personal", email: "john@doe.cc" },
          { name: "work", email: "john@acme.com" }
        ]
      }

const Person = () => {
    return (
        <div>
        <img className="person-avatar" src={data.avatar} alt="avatar"/>
        <h1 className="person-name">{data.name}</h1>
        <div>
            <h2>Phone  Number</h2>
            <ul>
                {data.phoneNumbers.map((phoneNumber, index) => (
                    <li key={index}>
                        {phoneNumber.name}: {phoneNumber.number}
                    </li>
                ))}
            </ul>    
        </div>
        <p></p>
        </div>
    );
    }

    export default Person;  